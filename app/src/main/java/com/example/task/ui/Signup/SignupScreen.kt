@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.task.ui.Signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.task.R

@Composable
fun  SignupScreen() {
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
        Signup(Modifier.padding(padding))
    }
}