/**
 * Licensed Materials - Property of hunchmen
 * 
 * (C) hunchmen. 2023. All Rights Reserved.
 * 
 */
package com.via.recipe.users.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.via.recipe.auth.model.dto.User;
import com.via.recipe.auth.repository.UserRepository;

/**
 * 
 * @author via
 * 
 * @date 20 Nov 2023
 *
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }
}
