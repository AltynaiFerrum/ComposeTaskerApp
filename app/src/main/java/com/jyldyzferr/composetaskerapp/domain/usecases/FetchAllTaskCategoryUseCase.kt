package com.jyldyzferr.composetaskerapp.domain.usecases

import com.jyldyzferr.composetaskerapp.domain.models.TaskCategory
import com.jyldyzferr.composetaskerapp.domain.repository.TaskCategoryRepository
import kotlinx.coroutines.flow.Flow

class FetchAllTaskCategoryUseCase(
    private val repository: TaskCategoryRepository
) {

    operator fun invoke(): Flow<List<TaskCategory>> {
        return repository.fetchAllTaskCategoriesFlow()
    }
}