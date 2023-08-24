package com.jyldyzferr.composetaskerapp.domain.models

import android.icu.text.CaseMap.Title
import java.util.UUID

data class  TaskCategory (
    val id: String,
    val title: String,
    val colorCode: String,
    ) {
    companion object {
        val preview = TaskCategory(
            id = UUID.randomUUID().toString(),
            title = "Inbox",
            colorCode = "#F45E6D"
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
            preview.copy(
                id = UUID.randomUUID().toString(),
            ),

        )
    }
}