package com.jyldyzferr.composetaskerapp.domain.usecases

import com.jyldyzferr.composetaskerapp.domain.models.TaskCategory
import com.jyldyzferr.composetaskerapp.domain.repository.TaskCategoryRepository

class FetchTaskCategoryUseCase(
    private val repository: TaskCategoryRepository
) {

    operator fun invoke(id: String): TaskCategory{
        return repository.fetchTaskCategoryById(id)
    }
}