package com.jyldyzferr.composetaskerapp.data.local

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.jyldyzferr.composetaskerapp.data.local.dao.TaskCategoryDao
import com.jyldyzferr.composetaskerapp.data.local.dao.TaskDao
import com.jyldyzferr.composetaskerapp.data.models.TaskCache
import com.jyldyzferr.composetaskerapp.data.models.TaskCategoryCache

@Database(
    entities = [TaskCache::class,
        TaskCategoryCache::class
               ],
    version = 2,
//    autoMigrations = [
//        AutoMigration(from = 1, to = 2)
//    ],
    exportSchema = true
)
abstract class TaskDatabase: RoomDatabase(){

    abstract fun fetchTaskDao(): TaskDao
    abstract fun fetchTaskCategoryDao(): TaskCategoryDao
}