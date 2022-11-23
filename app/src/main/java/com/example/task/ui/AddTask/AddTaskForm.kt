package com.example.task.ui.AddTask

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.TextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun AddTaskForm() {
    var containerWidth = LocalConfiguration.current.screenWidthDp.dp

    val description = remember { mutableStateOf(TextFieldValue()) }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextField(
            value = description.value,
            onValueChange = {description.value = it},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Description")
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TextField(
                value = description.value,
                onValueChange = {description.value = it},
                modifier = Modifier.requiredWidth(containerWidth/2-30.dp),
                label = {
                    Text(text = "Spent Hour(s)")
                },
            )
            TextField(
                value = description.value,
                onValueChange = {description.value = it},
                modifier = Modifier.requiredWidth(containerWidth/2-30.dp),
                label = {
                    Text(text = "Spent Minute(s)")
                },
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {}) {
            Text(text = "Add")
        }
    }
}