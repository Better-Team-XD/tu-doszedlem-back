package pl.teamxd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.teamxd.model.entity.MyUser;
import pl.teamxd.model.response.StandardResponse;
import pl.teamxd.model.response.Type;
import pl.teamxd.service.MyUserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/myUsers")
public class MyUserController {

    private final MyUserService myUserService;

    @PostMapping
    public ResponseEntity<?>  addMyUser(@RequestBody MyUser myUser) {
        try {
            return ResponseEntity.ok(
                new StandardResponse(Type.SUCCESS, "User added", myUserService.addMyUser(myUser))
            );
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(new StandardResponse(Type.ERROR, e.toString(), ""));
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<StandardResponse> getMyUserByUsername(@PathVariable String username) {
        try {
            return ResponseEntity.ok(
                    new StandardResponse(Type.SUCCESS, "User found", myUserService.getMyUserByUsername(username))
            );
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(new StandardResponse(Type.ERROR, e.toString(), ""));
        }
    }

    @GetMapping("/{username}/locations")
    public ResponseEntity<?> getUserLocations(@PathVariable String username) {
        try {
            return ResponseEntity.ok(
                    new StandardResponse(Type.SUCCESS, "Data queried", myUserService.getMyUserLocations(username))
            );
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(new StandardResponse(Type.ERROR, e.toString(), ""));
        }
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteMyUser(@PathVariable String username) {
        try {
            myUserService.deleteMyUser(username);
            return ResponseEntity.ok(
                    new StandardResponse(Type.SUCCESS, "User deleted", "")
            );
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(new StandardResponse(Type.ERROR, e.toString(), ""));
        }
    }

    // TODO: edit myUser
}
