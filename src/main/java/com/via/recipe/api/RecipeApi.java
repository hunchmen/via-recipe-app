/**
 * Licensed Materials - Property of hunchmen
 * 
 * (C) hunchmen. 2023. All Rights Reserved.
 * 
 */
package com.via.recipe.api;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.via.recipe.model.Recipe;
import com.via.recipe.model.RecipeDTO;

/**
 * 
 * @author via
 * 
 * @date 15 Nov 2023
 *
 */
public interface RecipeApi {

    public ResponseEntity<List<Recipe>> getAllRecipes();

    public ResponseEntity<RecipeDTO> addRecipe(RecipeDTO recipeDTO);

    public ResponseEntity<Boolean> updateRecipe(Long id, RecipeDTO recipeDTO);

    public ResponseEntity<Boolean> deleteRecipe(Long id);
}
