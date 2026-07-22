package com.brandertorres.mini_appconnavegacinviewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.brandertorres.mini_appconnavegacinviewmodel.data.Task
import com.brandertorres.mini_appconnavegacinviewmodel.data.sampleTasks

class TaskViewModel : ViewModel() {

    private val _tasks = mutableStateOf(sampleTasks)
    val tasks: State<List<Task>> = _tasks

    fun getTaskById(id: Int): Task? = _tasks.value.find { it.id == id }
}