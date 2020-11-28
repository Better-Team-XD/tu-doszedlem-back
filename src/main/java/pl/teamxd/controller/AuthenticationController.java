package pl.teamxd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import pl.teamxd.model.entity.MyUser;
import pl.teamxd.model.request.AuthenticationRequest;
import pl.teamxd.model.response.AuthenticationResponse;
import pl.teamxd.model.response.StandardResponse;
import pl.teamxd.model.response.Type;
import pl.teamxd.service.SecurityUserService;
import pl.teamxd.util.JwtUtil;

import java.security.Security;

@CrossOrigin
@RestController
@RequestMapping("/authenticate")
@RequiredArgsConstructor
public class AuthenticationController {
    private final SecurityUserService userService;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @PostMapping

    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
            UserDetails userDetails = userService
                    .loadUserByUsername(request.getUsername());

            String jwt = jwtUtil.generateToken(userDetails);
            return ResponseEntity.ok(new StandardResponse(Type.SUCCESS, "", new AuthenticationResponse(jwt)));
        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new StandardResponse(Type.ERROR, "", e.toString()));
        }
    }
}
