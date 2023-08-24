package com.jyldyzferr.composetaskerapp.domain.usecases

import com.jyldyzferr.composetaskerapp.domain.models.TaskCategory
import com.jyldyzferr.composetaskerapp.domain.repository.TaskRepository

class FetchTasksSizeByCategoryIdUseCase(
    private val repository: TaskRepository
) {

    operator fun invoke(categoryId: String): Int{
        return repository.fetchTasksSizeByCategoryId(categoryId)
    }
}