/**
 * Licensed Materials - Property of hunchmen
 * 
 * (C) hunchmen. 2023. All Rights Reserved.
 * 
 */
package com.via.recipe.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author via
 * 
 * @date 15 Nov 2023
 *
 */
@RestController
public class RecipeApiImpl implements RecipeApi {

    @Override
    @GetMapping("/getAllRecipes")
    public ResponseEntity<String> getAllRecipes() {
        return new ResponseEntity<>("Recipe API", HttpStatus.OK);
    }

}
