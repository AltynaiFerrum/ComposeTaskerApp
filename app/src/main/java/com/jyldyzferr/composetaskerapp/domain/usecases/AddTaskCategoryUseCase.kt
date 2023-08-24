package com.jyldyzferr.composetaskerapp.domain.usecases

import com.jyldyzferr.composetaskerapp.domain.models.TaskCategory
import com.jyldyzferr.composetaskerapp.domain.repository.TaskCategoryRepository

class AddTaskCategoryUseCase(
    private val repository: TaskCategoryRepository
) {

    operator fun invoke(taskCategory: TaskCategory){
        repository.addTaskCategory(taskCategory)
    }
}