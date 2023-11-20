/**
 * Licensed Materials - Property of hunchmen
 * 
 * (C) hunchmen. 2023. All Rights Reserved.
 * 
 */
package com.via.recipe.auth.api;

import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.via.recipe.auth.model.dto.LoginResponse;
import com.via.recipe.auth.model.dto.LoginUserDTO;
import com.via.recipe.auth.model.dto.RegisterUserDTO;
import com.via.recipe.auth.model.dto.User;
import com.via.recipe.auth.service.AuthenticationService;
import com.via.recipe.auth.service.JwtService;

/**
 * 
 * @author via
 * 
 * @date 20 Nov 2023
 *
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationApiImpl implements AuthenticationApi {

    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationApiImpl(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDTO registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDTO loginUserDto) {

        Optional<User> authenticatedUser = authenticationService.authenticate(loginUserDto);
        String jwtToken = null;

        if (authenticatedUser.isPresent()) {
            User user = authenticatedUser.get();

            UserDetails userDetails = user;

            jwtToken = jwtService.generateToken(userDetails);
        }


        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        System.out.println(jwtToken);

        return ResponseEntity.ok(loginResponse);
    }


}
