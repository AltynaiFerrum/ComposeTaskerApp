package com.jyldyzferr.composetaskerapp.domain.usecases

import com.jyldyzferr.composetaskerapp.domain.repository.TaskCategoryRepository

class DeleteTaskCategoryUseCase(
    private val repository: TaskCategoryRepository
) {

    operator fun invoke(id: String){
        repository.deleteTaskCategoryById(id)
    }
}