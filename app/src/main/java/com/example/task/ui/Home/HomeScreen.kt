@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.task.ui.Home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.task.Home
import com.example.task.ui.theme.PrimaryColor

@Composable
fun HomeScreen() {
    Scaffold(
        floatingActionButton = { FloatingAddButton() },
    ) { padding ->
        Home(Modifier.padding(padding))
    }
}

@Composable
fun FloatingAddButton() {
    FloatingActionButton(
        onClick = {},
        containerColor = PrimaryColor,
        contentColor = Color.White,
        shape = RoundedCornerShape(50.dp),
    ) {
        Icon(Icons.Filled.Add, contentDescription = "Add task")
    }
}
