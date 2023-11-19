/**
 * Licensed Materials - Property of hunchmen
 * 
 * (C) hunchmen. 2023. All Rights Reserved.
 * 
 */
package com.via.recipe.api;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.via.recipe.model.Recipe;
import com.via.recipe.model.RecipeDTO;
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

    /*
     * (non-Javadoc)
     * 
     * @see com.via.recipe.api.RecipeApi#addRecipe()
     */
    @Override
    @PostMapping("/save")
    @ApiOperation(value = "Add Recipe")
    public ResponseEntity<RecipeDTO> addRecipe(@RequestBody RecipeDTO recipeDTO) {

        Recipe recipe = new Recipe();
        recipe.setCuisine(recipeDTO.getCuisine());
        recipe.setRecipeName(recipeDTO.getRecipeName());
        recipeService.addRecipe(recipe);

        return new ResponseEntity<>(recipeDTO, HttpStatus.OK);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.via.recipe.api.RecipeApi#updateRecipe(com.via.recipe.model.Recipe)
     */
    @Override
    @PutMapping("/update/{id}")
    @ApiOperation(value = "Update Recipe")
    public ResponseEntity<Boolean> updateRecipe(@PathVariable Long id, @RequestBody RecipeDTO recipeDTO) {
        Optional<Recipe> existingRecipe = recipeService.findRecipeById(id);
        if (existingRecipe.isPresent()) {
            existingRecipe.get().setCuisine(recipeDTO.getCuisine());
            existingRecipe.get().setRecipeName(recipeDTO.getRecipeName());
            recipeService.updateRecipe(existingRecipe);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.OK);
        }

    }

}
