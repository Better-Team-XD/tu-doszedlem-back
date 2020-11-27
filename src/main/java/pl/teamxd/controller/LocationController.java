package pl.teamxd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.teamxd.model.request.LocationRequest;
import pl.teamxd.service.LocationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/locations")
public class LocationController {
    private final LocationService locationService;

    @GetMapping
    public LocationRequest getAllRequests(){
        return locationService.getLocations();
    }

}
