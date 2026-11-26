package com.example.trumpapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.trumpapp.R

val Monument = FontFamily(Font(R.font.monument))

val AppTypography = Typography(
    bodyLarge = TextStyle(fontFamily = Monument, fontSize = 14.sp),
    labelLarge = TextStyle(fontFamily = Monument, fontSize = 13.sp)
)