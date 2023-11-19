/**
 * Licensed Materials - Property of hunchmen
 * 
 * (C) hunchmen. 2023. All Rights Reserved.
 * 
 */
package com.via.recipe.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.via.recipe.model.Recipe;
import com.via.recipe.repository.RecipeRepository;

/**
 * 
 * @author via
 * 
 * @date 16 Nov 2023
 *
 */
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.via.recipe.service.RecipeService#getAllRecipes()
     */
    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.via.recipe.service.RecipeService#addRecipe(com.via.recipe.model.Recipe)
     */
    @Override
    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);

    }


    /*
     * (non-Javadoc)
     * 
     * @see com.via.recipe.service.RecipeService#findRecipe(java.lang.Long)
     */
    @Override
    public Optional<Recipe> findRecipeById(Long id) {

        return recipeRepository.findById(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.via.recipe.service.RecipeService#updateRecipe(java.util.Optional)
     */
    @Override
    public void updateRecipe(Optional<Recipe> existingRecipe) {

        Recipe recipe = existingRecipe.orElse(null);
        if (recipe != null) {
            recipeRepository.saveAndFlush(recipe);
        } else {
            throw new NullPointerException();
        }

    }

}
