package com.jyldyzferr.composetaskerapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jyldyzferr.composetaskerapp.data.models.TaskCache
import com.jyldyzferr.composetaskerapp.data.models.TaskCategoryCache
import com.jyldyzferr.composetaskerapp.domain.models.TaskCategory
import kotlinx.coroutines.flow.Flow

@Dao

interface TaskCategoryDao {

    @Insert
    fun addTaskCategory(taskCategory: TaskCategoryCache)

    @Query("DELETE  FROM task_categories_table WHERE id = :id")
    fun deleteTaskCategoryById(id: String)

    @Query("SELECT * FROM task_categories_table")
    fun fetchAllTaskCategoriesFlow(): Flow<List<TaskCategoryCache>>

    @Query("SELECT * FROM task_categories_table WHERE id = :id")
    fun fetchTaskCategoryById(id: String):TaskCategoryCache
}