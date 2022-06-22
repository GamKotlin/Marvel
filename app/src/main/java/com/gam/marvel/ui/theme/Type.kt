package com.gam.marvel.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.gam.marvel.R

val Typography = Typography(

    h1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.mollen, FontWeight.Normal)),
        fontSize = 45.sp,
        color = Color.White
    ),
    h2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.mollen, FontWeight.Normal)),
        fontSize = 25.sp,
        color = Color.White
    ),
    h3 = TextStyle(
        fontFamily = FontFamily(Font(R.font.mollen, FontWeight.Normal)),
        fontSize = 25.sp,
        color = Color.Black
    ),
    h4 = TextStyle(
        fontFamily = FontFamily(Font(R.font.mollen, FontWeight.Normal)),
        fontSize = 18.sp,
        color = Color.White
    ),
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )

)