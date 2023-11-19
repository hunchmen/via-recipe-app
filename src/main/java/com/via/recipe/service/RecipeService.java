/**
 * Licensed Materials - Property of hunchmen
 * 
 * (C) hunchmen. 2023. All Rights Reserved.
 * 
 */
package com.via.recipe.service;

import java.util.List;
import com.via.recipe.model.Recipe;

/**
 * 
 * @author via
 * 
 * @date 16 Nov 2023
 *
 */
public interface RecipeService {

    List<Recipe> getAllRecipes();

    Recipe addRecipe(Recipe recipe);
}
