/**
 * Licensed Materials - Property of hunchmen
 * 
 * (C) hunchmen. 2023. All Rights Reserved.
 * 
 */
package com.via.recipe.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.via.recipe.model.Recipe;

/**
 * 
 * @author via
 * 
 * @date 19 Nov 2023
 *
 */
public interface RecipePaginableRepository extends PagingAndSortingRepository<Recipe, Long> {

}
