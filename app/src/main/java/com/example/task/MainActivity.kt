package com.example.task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.task.ui.AddTask.AddTaskForm
import com.example.task.ui.AddTask.AddTaskScreen
import com.example.task.ui.Home.HomeScreen
import com.example.task.ui.Login.LoginScreen
import com.example.task.ui.Signup.SignupScreen
import com.example.task.ui.theme.TaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskTheme {
                AddTaskScreen()
//                AddTaskForm()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TaskTheme {
        AddTaskScreen()
    }
}