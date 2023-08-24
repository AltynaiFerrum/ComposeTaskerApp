package com.jyldyzferr.composetaskerapp.presentation.models

import com.jyldyzferr.composetaskerapp.domain.models.Task
import java.util.UUID

data class TaskUi(
    val id: String,
    val title: String,
    val time: String,
    val date: String,
    val categoryId: String,
    var isSelected: Boolean = false,
    val categoryColor:  String
) {


    companion object {
        val preview = TaskUi(
            id = UUID.randomUUID().toString(),
            time = "22:00",
            date = "04.05.2023",
            title = "Go to school",
            categoryId = "",
            categoryColor = "",

        )

        val previews = listOf(
            preview.copy(
                id = UUID.randomUUID().toString(),
            ),
            preview.copy(
                id = UUID.randomUUID().toString(),
            ),
            preview.copy(
                id = UUID.randomUUID().toString(),
            ),
            preview.copy(
                id = UUID.randomUUID().toString(),
            ),

            )
    }
}