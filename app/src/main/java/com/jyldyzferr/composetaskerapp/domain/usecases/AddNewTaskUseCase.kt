package com.jyldyzferr.composetaskerapp.domain.usecases

import com.jyldyzferr.composetaskerapp.domain.models.Task
import com.jyldyzferr.composetaskerapp.domain.repository.TaskRepository

class AddNewTaskUseCase(
    private val repository: TaskRepository
) {
    operator fun invoke(task: Task): Boolean{
        return repository.addNewTask(task)
    }
}