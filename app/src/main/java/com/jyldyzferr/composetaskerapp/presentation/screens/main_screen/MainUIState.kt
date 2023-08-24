package com.jyldyzferr.composetaskerapp.presentation.screens.main_screen

import com.jyldyzferr.composetaskerapp.domain.models.Task
import com.jyldyzferr.composetaskerapp.domain.models.TaskCategory
import com.jyldyzferr.composetaskerapp.presentation.models.TaskUi

data class MainUIState(

    val tasks: List<TaskUi> = emptyList(),
    val taskCategories: List<Pair<TaskCategory, Int>> = emptyList(),
    val selectedTasks: Set<TaskUi> = emptySet(),

    )