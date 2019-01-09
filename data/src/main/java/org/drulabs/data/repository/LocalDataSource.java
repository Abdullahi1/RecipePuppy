package org.drulabs.data.repository;

import org.drulabs.data.entity.DataRecipe;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface LocalDataSource {

    Observable<DataRecipe> getSavedRecipes();

    Completable saveRecipe(DataRecipe recipe);

    Completable deleteRecipe(DataRecipe recipe);

    Completable deleteAllRecipes();

    Single<DataRecipe> getLastSavedRecipe();

}