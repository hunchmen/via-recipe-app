/**
 * Licensed Materials - Property of hunchmen
 * 
 * (C) hunchmen. 2023. All Rights Reserved.
 * 
 */
package com.via.recipe.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.via.recipe.model.Recipe;
import com.via.recipe.service.RecipeService;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author via
 * 
 * @date 15 Nov 2023
 *
 */
@RestController
public class RecipeApiImpl implements RecipeApi {

    @Autowired
    private RecipeService recipeService;

    @Override
    @GetMapping("/recipes")
    @ApiOperation(value = "Retrieve All Recipes")
    public ResponseEntity<List<Recipe>> getAllRecipes() {

        List<Recipe> recipes = recipeService.getAllRecipes();

        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

}
