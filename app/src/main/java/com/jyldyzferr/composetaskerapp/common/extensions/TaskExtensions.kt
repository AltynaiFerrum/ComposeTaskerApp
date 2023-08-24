package com.jyldyzferr.composetaskerapp.common.extensions

import com.jyldyzferr.composetaskerapp.data.models.TaskCache
import com.jyldyzferr.composetaskerapp.domain.models.Task
import com.jyldyzferr.composetaskerapp.presentation.models.TaskUi

fun Task.mapToCache(): TaskCache {
    return TaskCache(
        id = id,
        title = title,
        time = time,
        date = date,
        categoryId = categoryId,
        categoryColor = categoryColor,
        )
}

fun TaskCache.mapToTask(): Task{
    return Task(
        id = id,
        title = title,
        time = time,
        date = date,
        categoryId = categoryId,
        categoryColor = categoryColor,

    )
}

fun Task.mapToTaskUi(): TaskUi{
    return TaskUi(
        id = id,
        title = title,
        time = time,
        date = date,
        categoryId = categoryId,
        categoryColor = categoryColor,

        )
}