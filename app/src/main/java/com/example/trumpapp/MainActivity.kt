package com.example.trumpapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.trumpapp.ui.theme.AppTheme
import com.example.trumpapp.ui.theme.Screen1
import com.example.trumpapp.ui.theme.Screen2
import com.example.trumpapp.ui.theme.Screen3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                AppScreens()
            }
        }
    }
}

@Composable
fun AppScreens() {
    val screen = remember { mutableStateOf(1) }

    when (screen.value) {
        1 -> Screen1(onContribute = { screen.value = 2 })
        2 -> Screen2(onAddToCart = { screen.value = 3 })
        else -> Screen3(onBack = { screen.value = 2 })
    }
}