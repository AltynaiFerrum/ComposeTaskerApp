package com.jyldyzferr.composetaskerapp.presentation.screens.main_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jyldyzferr.composetaskerapp.common.extensions.mapToTaskUi
import com.jyldyzferr.composetaskerapp.data.repository.TaskCategoryRepositoryImpl
import com.jyldyzferr.composetaskerapp.data.repository.TaskRepositoryImpl
import com.jyldyzferr.composetaskerapp.domain.repository.TaskCategoryRepository
import com.jyldyzferr.composetaskerapp.domain.repository.TaskRepository
import com.jyldyzferr.composetaskerapp.domain.usecases.FetchAllTaskCategoryUseCase
import com.jyldyzferr.composetaskerapp.domain.usecases.FetchAllTasksUseCase
import com.jyldyzferr.composetaskerapp.domain.usecases.FetchTaskCategoryUseCase
import com.jyldyzferr.composetaskerapp.domain.usecases.FetchTasksSizeByCategoryIdUseCase
import com.jyldyzferr.composetaskerapp.domain.usecases.RemoveTasksByIdsUseCase
import com.jyldyzferr.composetaskerapp.presentation.models.TaskUi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

class MainViewModel : ViewModel() {

    private val repository: TaskRepository = TaskRepositoryImpl()
    private val taskCategoryRepository = TaskCategoryRepositoryImpl()


    private val fetchAllTasksUseCase = FetchAllTasksUseCase(repository)
    private val removeTasksByIdsUseCase = RemoveTasksByIdsUseCase(repository)

    private val fetchAllTaskCategoryUseCase = FetchAllTaskCategoryUseCase(taskCategoryRepository)
    private val fetchTasksSizeByCategoryIdUseCase = FetchTasksSizeByCategoryIdUseCase(repository)

    var uiState by mutableStateOf(MainUIState())

    init {
        fetchAllTasksUseCase()
            .onEach { tasks ->
            uiState = uiState.copy(
                tasks = tasks.map{task -> task.mapToTaskUi()})
        }.launchIn(viewModelScope)

        fetchAllTaskCategoryUseCase()
            .map { taskCategories ->
                val taskCategoryAndCount = taskCategories.map{category ->
                    val count = fetchTasksSizeByCategoryIdUseCase(categoryId = category.id)
                    Pair(category,count)
                }
                taskCategoryAndCount

            }
            .onEach { taskCategories ->
            uiState = uiState.copy(taskCategories = taskCategories)
        }.launchIn(viewModelScope)
    }


    fun onSelectItem(task: TaskUi, isSelected: Boolean){
        val selectedTasks = uiState.selectedTasks.toMutableSet()
        if (isSelected) {
            selectedTasks.add(task)
        } else {
            selectedTasks.remove(task)
        }
        uiState = uiState.copy(selectedTasks = selectedTasks)
    }

    fun removeSelectedItems(){
        val removedTasks = uiState.selectedTasks
        val taskIds = removedTasks.map { task: TaskUi -> task.id }
        removeTasksByIdsUseCase(taskIds)
    }

    fun selectAllItems (){
       val selectedTasks = uiState.selectedTasks.toMutableSet()
        selectedTasks.addAll(uiState.tasks)
        uiState = uiState.copy(selectedTasks = selectedTasks)
    }

    fun unSelectAllItems(){
    val selectedTasks = uiState.selectedTasks.toMutableSet()
        selectedTasks.clear()
        uiState = uiState.copy(selectedTasks = selectedTasks)

    }
}

