package com.example.task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.task.ui.theme.TaskTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskTheme {
                Scaffold(
                    floatingActionButton = { FloatingButton() },
                ) { padding ->
                    Home(Modifier.padding(padding))
                }
            }
        }
    }
}

@Composable
fun FloatingButton() {
    FloatingActionButton(
        onClick = {},
        containerColor = Color.Blue,
        contentColor = Color.White,
        shape = RoundedCornerShape(50.dp),
    ) {
        androidx.compose.material3.Icon(Icons.Filled.Add, contentDescription = "")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TaskTheme {
        Home()
    }
}