package com.jyldyzferr.composetaskerapp.domain.repository

import com.jyldyzferr.composetaskerapp.data.models.TaskCategoryCache
import com.jyldyzferr.composetaskerapp.domain.models.TaskCategory
import kotlinx.coroutines.flow.Flow

interface TaskCategoryRepository {

    fun addTaskCategory(task: TaskCategory)

    fun deleteTaskCategoryById(id: String)

    fun fetchAllTaskCategoriesFlow(): Flow<List<TaskCategory>>

    fun fetchTaskCategoryById(id: String): TaskCategory

}