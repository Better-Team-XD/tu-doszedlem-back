package pl.teamxd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.teamxd.model.entity.Location;
import pl.teamxd.service.LocationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/locations")
public class LocationController {
    private final LocationService locationService;

    @GetMapping
    public ResponseEntity<?> getAllLocations(){
        try{
            return ResponseEntity.ok(locationService.getLocations());
        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.toString());
        }
    }

    @PostMapping
    public ResponseEntity<?> addLocation(@RequestBody Location location){
        try {
            return ResponseEntity.ok(locationService.addLocation(location));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.toString());
        }
    }
}
