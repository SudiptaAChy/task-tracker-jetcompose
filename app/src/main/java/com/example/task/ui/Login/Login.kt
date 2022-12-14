@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.task

import androidx.compose.foundation.Image
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task.Config.*

@Composable
fun Login(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        HeaderPart()
        EmailField()
        PasswordFiled()
        RememberMeLayout()
        SubmitButton()
        FingerprintImage()
        FooterPart()
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
            "Login",
            style = gradientTextStyle1,
        )
        Text(
            "Enter info for login",
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
            .padding(top = 10.dp)
            .background(gradientColor, shape = RoundedCornerShape(50.dp)),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
    ) {
        Text(
            "Login",
            style = buttonTextStyle,
        )
    }
}

@Composable
fun RememberMeLayout() {
    var checkedState = remember { mutableStateOf(false) }

    Row {
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Blue
            )
        )
        Text("Remember me", modifier = Modifier.padding(top = 12.dp))
        Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            Text(
                "Forgot password?",
                modifier = Modifier.padding(top = 13.dp),
                style = TextStyle(color = Color.Gray)
            )
        }
    }
}

@Composable
fun FingerprintImage() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.ic_biometric),
            contentDescription = "Finger print",
            modifier = Modifier
                .height(80.dp)
                .width(80.dp)
                .padding(top = 20.dp),
            alignment = Alignment.Center
        )
    }
}

@Composable
fun FooterPart() {
    Row (
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        GetCardItem(image = R.drawable.ic_today_rate, title = "Today's rate")
        GetCardItem(image = R.drawable.ic_register, title = "Register")
        GetCardItem(image = R.drawable.ic_support, title = "Support")
    }
}

@Composable
fun GetCardItem(
    image: Int,
    title:String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = RoundedCornerShape(15.dp),
            colors = CardDefaults.cardColors (
                containerColor = Color.White,
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp,
            ),
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = title,
                modifier = Modifier.padding(5.dp),
                alignment = Alignment.Center
            )
        }
        Text(title, modifier = Modifier.padding(top = 2.dp), style = TextStyle(fontSize = 12.sp))
    }
}