@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.task.ui.AddTask

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task.Config.buttonTextStyle
import com.example.task.ui.theme.PrimaryColor

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun AddTaskScreen() {
    Scaffold(
        topBar = { AppBar() },
        floatingActionButton = { FloatingSubmitButton() },
        floatingActionButtonPosition = FabPosition.Center,
    ) { padding ->
        BottomSheetForm(Modifier.padding(padding))
    }
}

@Composable
fun AppBar() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = PrimaryColor,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
        ),
        title = {Text("Add Task")},
    )
}

@Composable
fun FloatingSubmitButton() {
    FloatingActionButton(
        onClick = {},
        containerColor = PrimaryColor,
        contentColor = Color.White,
        shape = RoundedCornerShape(50.dp),
        modifier = Modifier.width(180.dp).height(45.dp),
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = 0.dp
        )
    ) {
        Text(
            text = "Submit",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}