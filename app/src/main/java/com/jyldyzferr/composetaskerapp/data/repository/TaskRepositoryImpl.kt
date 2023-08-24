package com.jyldyzferr.composetaskerapp.data.repository

import com.jyldyzferr.composetaskerapp.domain.models.Task
import com.jyldyzferr.composetaskerapp.domain.models.TaskCategory
import com.jyldyzferr.composetaskerapp.domain.repository.TaskRepository
import com.jyldyzferr.composetaskerapp.presentation.TaskApp
import com.jyldyzferr.composetaskerapp.common.extensions.mapToCache
import com.jyldyzferr.composetaskerapp.common.extensions.mapToTask
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TaskRepositoryImpl: TaskRepository {

    private val dao = TaskApp.database.fetchTaskDao()

    override fun fetchAllTasksFlow(): Flow<List<Task>> {
       return dao
           .fetchAllTasksFlow()
           .map { it.map { it.mapToTask() } }
    }

    override fun fetchAllTaskCategories(): List<TaskCategory> {
        TODO("Not yet implemented")
    }

    override fun fetchTasksByCategoryId(categoryId: String): List<Task> {
        TODO("Not yet implemented")
    }

    override fun fetchTasksSizeByCategoryId(categoryId: String): Int {
        return dao.fetchTasksSizeByCategoryId(categoryId).size
    }

    override fun fetchTaskById(taskId: String): Task {
        TODO("Not yet implemented")
    }

    override fun fetchTaskCategoryById(categoryId: String): TaskCategory {
        TODO("Not yet implemented")
    }

    override fun addNewTask(task: Task): Boolean {
        dao.addNewTask(task.mapToCache())
        return true
    }

    override fun updateTask(task: Task) {
        TODO("Not yet implemented")
    }

    override fun removeTaskById(id: String) {
        TODO("Not yet implemented")
    }

    override fun removeTasksById(ids: List<String>) {
    dao.deleteTasksByIds(ids)
    }
}