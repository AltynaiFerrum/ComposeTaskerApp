package com.jyldyzferr.composetaskerapp.presentation.screens.add_screen

import com.jyldyzferr.composetaskerapp.domain.models.TaskCategory

data class AddTaskScreenUIState (
    val selectedCategory: TaskCategory? = null,
    val selectedDate: String? = null,
    val selectedTime: String? = null,
    val title: String? = null,
    val tasksCategories: List<TaskCategory> = emptyList()

)