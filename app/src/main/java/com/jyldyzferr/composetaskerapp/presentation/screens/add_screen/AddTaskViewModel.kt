package com.jyldyzferr.composetaskerapp.presentation.screens.add_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jyldyzferr.composetaskerapp.R
import com.jyldyzferr.composetaskerapp.data.repository.TaskCategoryRepositoryImpl
import com.jyldyzferr.composetaskerapp.data.repository.TaskRepositoryImpl
import com.jyldyzferr.composetaskerapp.domain.models.Task
import com.jyldyzferr.composetaskerapp.domain.models.TaskCategory
import com.jyldyzferr.composetaskerapp.domain.repository.TaskRepository
import com.jyldyzferr.composetaskerapp.domain.usecases.AddNewTaskUseCase
import com.jyldyzferr.composetaskerapp.domain.usecases.FetchAllTaskCategoryUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.UUID

class AddTaskViewModel: ViewModel() {

    private val repository: TaskRepository = TaskRepositoryImpl()
    private val taskCategoryRepository = TaskCategoryRepositoryImpl()

    private val addNewTaskUseCase = AddNewTaskUseCase(repository)
    private val fetchAllTaskCategoryUseCase = FetchAllTaskCategoryUseCase(taskCategoryRepository)

    var uiState by mutableStateOf(AddTaskScreenUIState())

    private val _toastFlow = MutableSharedFlow<Int?>(1)
    val toastFlow = _toastFlow.asSharedFlow()

    private val _navigateUpFlow = MutableStateFlow<Unit?>(null)
    val navigateUpFlow = _navigateUpFlow.asStateFlow()

    init {
        fetchAllTaskCategoryUseCase().onEach { taskCategories ->
            uiState = uiState.copy(tasksCategories = taskCategories)
        }.launchIn(viewModelScope)
    }

    fun updatedSelectedDate(date:String){
        uiState = uiState.copy(selectedDate = date)
    }

    fun updatedSelectedTime(time:String){
        uiState = uiState.copy(selectedTime = time)
    }

    fun updatedSelectedCategory(category:TaskCategory){
        uiState = uiState.copy(selectedCategory  = category)
    }
    fun updatedTaskTitle(title: String) {
        uiState = uiState.copy(title = title)
    }

    fun addNewTask() {
        if (uiState.title.isNullOrBlank()) {
            _toastFlow.tryEmit(R.string.error_empty_title)
            return
        }
        if (uiState.selectedDate.isNullOrBlank()) {
            _toastFlow.tryEmit(R.string.error_empty_date)
            return
        }
        if (uiState.selectedTime.isNullOrBlank()) {
            _toastFlow.tryEmit(R.string.error_empty_time)
            return
        }
        if (uiState.selectedCategory == null) {
            _toastFlow.tryEmit(R.string.error_empty_time)
            return
        }
        val task = Task(
            id = UUID.randomUUID().toString(),
            time = uiState.selectedTime!!,
            date = uiState.selectedDate!!,
            categoryId = uiState.selectedCategory!!.id,
            title = uiState.title!!,
            categoryColor = uiState.selectedCategory!!.colorCode
        )

        addNewTaskUseCase(task)
        uiState= AddTaskScreenUIState()
        _navigateUpFlow.tryEmit(Unit)

    }
}