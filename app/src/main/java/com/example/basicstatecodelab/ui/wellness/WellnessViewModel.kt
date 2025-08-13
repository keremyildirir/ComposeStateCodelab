package com.example.basicstatecodelab.ui.wellness

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.toMutableStateList
import com.example.basicstatecodelab.ui.wellness.model.WellnessTask

class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks


    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    fun changeTaskChecked(item: WellnessTask, checked: Boolean) =
        _tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }
}

fun getWellnessTasks() = List(24) { i -> WellnessTask(i + 1, "Task #${i + 1}") }