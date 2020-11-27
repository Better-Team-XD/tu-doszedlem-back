package pl.teamxd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.teamxd.model.request.LocationRequest;
import pl.teamxd.repository.LocationRepository;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationRequest getLocations() {
        return new LocationRequest(locationRepository.findAll());
    }
}
