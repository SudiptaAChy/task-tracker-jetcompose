@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.task.ui.theme.TaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskTheme {
                LoginScreen()
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Scaffold(
        floatingActionButton = { FloatingButton() },
    ) { padding ->
        Home(Modifier.padding(padding))
    }
}

@Composable
fun LoginScreen() {
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.login_background),
            contentDescription = "background_image",
            contentScale = ContentScale.FillBounds
        )
    }
    Scaffold(
        containerColor = Color.Transparent,
    ) { padding ->
        Login(Modifier.padding(padding))
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

@Preview(showBackground = true, name = "Login screen")
@Composable
fun DefaultPreview() {
    TaskTheme {
        LoginScreen()
    }
}