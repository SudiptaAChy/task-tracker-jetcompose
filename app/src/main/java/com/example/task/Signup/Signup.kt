@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.task.Signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task.*
import com.example.task.Config.gradientColor
import com.example.task.Config.gradientTextStyle1
import com.example.task.Config.textStyle1
import com.example.task.Config.textStyle2
import com.example.task.R
import com.example.task.ui.theme.gradientColor1
import com.example.task.ui.theme.gradientColor2
import com.example.task.ui.theme.gradientColor3

@Composable
fun Signup(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().padding(20.dp)
    ) {
        HeaderPart()
        EmailField()
        PasswordFiled()
        SubmitButton()
    }
}

@Composable
fun HeaderPart() {
    Column() {
        Image(
            painter = painterResource(id = R.drawable.cbl_main_logo),
            contentDescription = "Main logo",
            modifier = Modifier.padding(top = 20.dp, bottom = 10.dp)
        )
        Text(
            "Signup",
            style = gradientTextStyle1,
        )
        Text(
            "Enter info for Signup",
            style = textStyle2,
        )
    }
}

@Composable
fun EmailField() {
    val email = remember { mutableStateOf(TextFieldValue()) }

    TextField (
        value = email.value,
        onValueChange = { email.value = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
            .background(gradientColor, shape = RoundedCornerShape(50.dp)
            ),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            cursorColor = Color.White,
            disabledLabelColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(50.dp),
        textStyle = textStyle1,
        placeholder = { Text(
            "Enter Email",
            style = textStyle1,
        ) },
    )
}

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
            .background(gradientColor, shape = RoundedCornerShape(50.dp)
            ),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            cursorColor = Color.White,
            disabledLabelColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(50.dp),
        textStyle = textStyle1,
        placeholder = { Text(
            "Password",
            style = textStyle1,
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
            "Signup",
            style = TextStyle(
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            ),
        )
    }
}