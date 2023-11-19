/**
 * Licensed Materials - Property of hunchmen
 * 
 * (C) hunchmen. 2023. All Rights Reserved.
 * 
 */
package com.via.recipe.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import com.via.recipe.model.Recipe;

/**
 * 
 * @author via
 * 
 * @date 16 Nov 2023
 *
 */
public interface RecipeService {

    Page<Recipe> getRecipes(int page, int size, String sortBy);

    List<Recipe> getAllRecipes();

    Recipe addRecipe(Recipe recipe);

    void updateRecipe(Optional<Recipe> existingRecipe);

    void deleteRecipe(Long id);

    Optional<Recipe> findRecipeById(Long id);
}
