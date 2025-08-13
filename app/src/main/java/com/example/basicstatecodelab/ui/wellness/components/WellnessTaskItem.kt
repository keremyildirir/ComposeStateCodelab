package com.example.basicstatecodelab.ui.wellness.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WellnessTaskItem(
    taskName: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = taskName,
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp),
            style = MaterialTheme.typography.bodyLarge
        )
        Checkbox(checked = checked, onCheckedChange = onCheckedChange)
        IconButton(onClick = onClose) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "Remove",
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWellnessTaskItem() {
    MaterialTheme {
        WellnessTaskItem(
            taskName = "Drink Water",
            checked = false,
            onCheckedChange = {},
            onClose = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWellnessTaskItemChecked() {
    MaterialTheme {
        WellnessTaskItem(
            taskName = "Morning Run",
            checked = true,
            onCheckedChange = {},
            onClose = {}
        )
    }
}