@file:OptIn(ExperimentalTextApi::class)

package com.example.task.Config

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val textStyle1 = TextStyle(
    color = Color.White,
    fontSize = 16.sp,
    letterSpacing = 3.sp,
)

val textStyle2 = TextStyle(
fontSize = 18.sp,
fontWeight = FontWeight.Bold,
)

@OptIn(ExperimentalTextApi::class)
val gradientTextStyle1 = TextStyle(
    fontSize = 26.sp,
    fontWeight = FontWeight.Bold,
    letterSpacing = 3.sp,
    brush = gradientColor,
)