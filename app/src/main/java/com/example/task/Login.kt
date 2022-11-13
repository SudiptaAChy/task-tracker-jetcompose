package com.example.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val gradientColor = Brush.horizontalGradient(listOf(Color(0xFFED1556), Color(0xFFB24198), Color(0xFF2EB1E6)))

@Composable
fun Login(modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .fillMaxSize()
        .padding(20.dp)
    ) {
        Column(modifier = modifier) {
            EmailField()
            PasswordFiled()
            SubmitButton()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailField() {
    val email = remember { mutableStateOf(TextFieldValue()) }

    TextField (
        value = email.value,
        onValueChange = { email.value = it },
        modifier = Modifier
            .fillMaxWidth()
            .background(
                gradientColor, shape = RoundedCornerShape(50.dp)
            ),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            cursorColor = Color.White,
            disabledLabelColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(50.dp),
        textStyle = TextStyle(
            color = Color.White,
            fontSize = 16.sp,
            letterSpacing = 3.sp,
        ),
        placeholder = { Text(
            "Enter Email",
            style = TextStyle(
                color = Color.White,
                fontSize = 16.sp,
                letterSpacing = 3.sp,
            ),
        ) },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordFiled() {
    val password = remember { mutableStateOf(TextFieldValue()) }
    var passwordVisible = remember { mutableStateOf(false) }

    TextField (
        value = password.value,
        onValueChange = { password.value = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
            .background(
                gradientColor, shape = RoundedCornerShape(50.dp)
            ),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            cursorColor = Color.White,
            disabledLabelColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(50.dp),
        textStyle = TextStyle(
            color = Color.White,
            fontSize = 16.sp,
            letterSpacing = 3.sp,
        ),
        placeholder = { Text(
            "Password",
            style = TextStyle(
                color = Color.White,
                fontSize = 16.sp,
                letterSpacing = 3.sp,
            ),
        ) },
        trailingIcon = {
            val image = if (passwordVisible.value)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff

            val description = if (passwordVisible.value) "Hide password" else "Show password"
            
            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector  = image, contentDescription = description, tint = Color.White)
            }
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
    )
}

@Composable
fun SubmitButton() {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
            .background(gradientColor, shape = RoundedCornerShape(50.dp)),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
    ) {
        Text(
            "Login",
            style = TextStyle(
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            ),
        )
    }
}
