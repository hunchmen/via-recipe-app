/**
 * Licensed Materials - Property of hunchmen
 * 
 * (C) hunchmen. 2023. All Rights Reserved.
 * 
 */
package com.via.recipe.service;

import java.util.List;
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

}
