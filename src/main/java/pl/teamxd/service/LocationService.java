package pl.teamxd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.teamxd.model.entity.Location;
import pl.teamxd.model.response.LocationRequest;
import pl.teamxd.repository.LocationRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationRequest getLocations() {
        return new LocationRequest(locationRepository.findAll());
    }

    public Location addLocation(Location location){
        if (location.getDate() == null){
            location.setDate(LocalDateTime.now());
        }
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
