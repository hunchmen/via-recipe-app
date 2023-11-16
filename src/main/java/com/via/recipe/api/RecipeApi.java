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

/**
 * 
 * @author via
 * 
 * @date 15 Nov 2023
 *
 */
public interface RecipeApi {

    public ResponseEntity<List<Recipe>> getAllRecipes();
}
