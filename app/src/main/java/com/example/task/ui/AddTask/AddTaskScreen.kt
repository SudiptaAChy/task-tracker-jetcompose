@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.task.ui.AddTask

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.task.Config.buttonTextStyle
import com.example.task.ui.theme.PrimaryColor

@Composable
fun AddTaskScreen() {
    Scaffold(
        floatingActionButton = { FloatingSubmitButton() },
    ) { padding ->
        AddTask(Modifier.padding(padding))
    }
}

@Composable
fun FloatingSubmitButton() {
    FloatingActionButton(
        onClick = {},
        containerColor = PrimaryColor,
        contentColor = Color.White,
        shape = RoundedCornerShape(10.dp),
    ) {
        Text(text = "Submit", style = buttonTextStyle)
    }
}