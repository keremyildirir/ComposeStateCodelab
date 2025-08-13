package com.example.basicstatecodelab.ui.wellness.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicstatecodelab.ui.wellness.model.WellnessTask

@Composable
fun WellnessTasksList(
    list: List<WellnessTask>,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = list,
            key = { task -> task.id }
        ) { task ->
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            ) {
                WellnessTaskItem(
                    taskName = task.label,
                    checked = task.checked,
                    onCheckedChange = { checked -> onCheckedTask(task, checked) },
                    onClose = { onCloseTask(task) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWellnessTasksList() {
    val sampleTasks =
        List(5) { i -> WellnessTask(i, "Task #${i + 1}", initialChecked = i % 2 == 0) }
    MaterialTheme {
        WellnessTasksList(
            list = sampleTasks,
            onCheckedTask = { _, _ -> },
            onCloseTask = {}
        )
    }
}