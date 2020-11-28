package pl.teamxd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.teamxd.model.entity.Location;
import pl.teamxd.model.response.StandardResponse;
import pl.teamxd.model.response.Type;
import pl.teamxd.service.LocationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/locations")
public class LocationController {
    private final LocationService locationService;

    @GetMapping
    public ResponseEntity<StandardResponse> getAllLocations(){
        try{
            return ResponseEntity.ok(
                    new StandardResponse(Type.SUCCESS, "Data queried", locationService.getLocations())
            );
        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(new StandardResponse(Type.ERROR, e.toString(), ""));
        }
    }

    @PostMapping
    public ResponseEntity<?> addLocation(@RequestBody Location location){
        try {
            return ResponseEntity.ok(
                    new StandardResponse(Type.SUCCESS, "Location added", locationService.addLocation(location))
            );
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(new StandardResponse(Type.ERROR, e.toString(), ""));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeLocation(@PathVariable long id){
        try{
            locationService.deleteLocation(id);
            return ResponseEntity.ok(
                    new StandardResponse(Type.SUCCESS, "Location deleted", "")
            );
        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(new StandardResponse(Type.ERROR, e.toString(), ""));
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> editLocation(@PathVariable long id, @RequestBody Location newLocation){
        try {
            return ResponseEntity.ok(
                    new StandardResponse(Type.SUCCESS, "Location edited", locationService.editLocation(id, newLocation))
            );
        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(new StandardResponse(Type.ERROR, e.toString(), ""));
        }
    }
}
