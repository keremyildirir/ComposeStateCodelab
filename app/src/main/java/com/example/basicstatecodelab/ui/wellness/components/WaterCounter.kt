package com.example.basicstatecodelab.ui.wellness.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Card(modifier = modifier, shape = RoundedCornerShape(16.dp)) {
        Column(Modifier.padding(16.dp)) {
            if (count > 0) {
                Text(
                    text = "You've had $count glasses.",
                    style = MaterialTheme.typography.titleMedium
                )
            } else {
                Text(
                    text = "Track your water",
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Spacer(Modifier.height(8.dp))
            Button(
                onClick = onIncrement,
                enabled = count < 10
            ) {
                Text("Add one")
            }
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableIntStateOf(0) }
    StatelessCounter(count = count, onIncrement = { count++ }, modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun PreviewStatefulCounter() {
    MaterialTheme {
        StatefulCounter()
    }
}