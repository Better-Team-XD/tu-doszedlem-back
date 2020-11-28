package pl.teamxd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.teamxd.model.entity.Location;
import pl.teamxd.model.entity.MyUser;
import pl.teamxd.model.response.LocationResponse;
import pl.teamxd.repository.LocationRepository;
import pl.teamxd.repository.MyUserRepository;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;
    private final MyUserRepository myUserRepository;

    public LocationResponse getLocations() {
        return new LocationResponse(locationRepository.findAll());
    }

    public Location addLocation(Location location, String username){

        if (location.getDate() == null){
            location.setDate(LocalDateTime.now());
        }

        MyUser myUser = myUserRepository.findMyUserByUsername(username)
                .orElseThrow(EntityNotFoundException::new);
        myUser.addLocation(location);

        return locationRepository.save(location);
    }

    public void deleteLocation(long locationId){
        locationRepository.deleteById(locationId);
    }

    public Location editLocation(long locationId, Location newLocation){
        Location previousLocation = locationRepository.findById(locationId)
                .orElseThrow(IllegalArgumentException::new);

        previousLocation.updateLocation(newLocation);
        return locationRepository.save(previousLocation);
    }
}
