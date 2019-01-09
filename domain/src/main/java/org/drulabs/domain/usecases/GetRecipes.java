package org.drulabs.domain.usecases;

import org.drulabs.domain.entities.Recipe;
import org.drulabs.domain.entities.RecipeRequest;
import org.drulabs.domain.repository.RecipeRepository;
import org.drulabs.domain.usecases.base.ObservableUseCase;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

public class GetRecipes extends ObservableUseCase<Recipe, RecipeRequest> {

    private RecipeRepository repository;

    @Inject
    public GetRecipes(RecipeRepository repository, @Named("execution") Scheduler
            executionScheduler, @Named("postExecution") Scheduler postExecutionScheduler) {
        super(executionScheduler, postExecutionScheduler);
        this.repository = repository;
    }

    @Override
    protected Observable<Recipe> build(RecipeRequest request) {
        return repository.getRecipes(request.getSearchQuery(), request.getPageNum());
    }
}