package com.example.basicstatecodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.basicstatecodelab.ui.theme.BasicStateCodelabTheme
import com.example.basicstatecodelab.ui.wellness.WellnessScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WellnessApp()
        }
    }
}

@Composable
fun WellnessApp() {
    BasicStateCodelabTheme(darkTheme = false, dynamicColor = false) {
        Scaffold{ innerPadding ->
            WellnessScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    WellnessApp()
}