/**
 * Licensed Materials - Property of hunchmen
 * 
 * (C) hunchmen. 2023. All Rights Reserved.
 * 
 */
package com.via.recipe.auth.api;

import org.springframework.http.ResponseEntity;
import com.via.recipe.auth.model.dto.LoginResponse;
import com.via.recipe.auth.model.dto.LoginUserDTO;
import com.via.recipe.auth.model.dto.RegisterUserDTO;
import com.via.recipe.auth.model.dto.User;

/**
 * 
 * @author via
 * 
 * @date 20 Nov 2023
 *
 */
public interface AuthenticationApi {

    ResponseEntity<User> register(RegisterUserDTO registerUserDTO);

    ResponseEntity<LoginResponse> authenticate(LoginUserDTO loginUserDTO);
}
