package com.jyldyzferr.composetaskerapp.domain.usecases

import com.jyldyzferr.composetaskerapp.domain.repository.TaskRepository

class RemoveTasksByIdsUseCase(
    private val repository: TaskRepository
) {
    operator fun invoke(ids: List<String>) {
        repository.removeTasksById(ids)
    }
}