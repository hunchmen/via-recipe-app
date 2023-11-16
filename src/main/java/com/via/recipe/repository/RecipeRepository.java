/**
 * Licensed Materials - Property of hunchmen
 * 
 * (C) hunchmen. 2023. All Rights Reserved.
 * 
 */
package com.via.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.via.recipe.model.Recipe;

/**
 * 
 * @author via
 * 
 * @date 16 Nov 2023
 *
 */
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
