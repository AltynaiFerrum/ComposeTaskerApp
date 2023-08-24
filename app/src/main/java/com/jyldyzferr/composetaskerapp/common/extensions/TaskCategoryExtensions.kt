package com.jyldyzferr.composetaskerapp.common.extensions

import com.jyldyzferr.composetaskerapp.data.models.TaskCache
import com.jyldyzferr.composetaskerapp.data.models.TaskCategoryCache
import com.jyldyzferr.composetaskerapp.domain.models.Task
import com.jyldyzferr.composetaskerapp.domain.models.TaskCategory

fun TaskCategory.toCache(): TaskCategoryCache {
    return TaskCategoryCache(
        id = id,
        title = title,
        colorCode = colorCode
    )
}

fun TaskCategoryCache.toCategory(): TaskCategory {
    return TaskCategory(
        id = id,
        title = title,
        colorCode = colorCode
    )
}

