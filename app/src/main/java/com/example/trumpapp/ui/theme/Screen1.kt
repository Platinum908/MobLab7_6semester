package com.example.trumpapp.ui.theme

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.unit.*
import com.example.trumpapp.R

@Composable
fun Screen1(onContribute: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.trump),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
                .padding(16.dp)
        ) {
            Screen1TopBar()
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "TOGETHER, WE ARE\nREBUILDING OUR NATION",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.weight(1f))
            Screen1Buttons(onContribute)
        }
    }
}

@Composable
private fun Screen1TopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "TRUMP", color = Color.White, fontWeight = FontWeight.Bold)
        Text(text = "☰", color = Color.White)
    }
}

@Composable
private fun Screen1Buttons(onContribute: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = onContribute,
            modifier = Modifier.weight(1f).height(60.dp),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = AppBlue)
        ) {
            Text(text = "CONTRIBUTE  →")
        }
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = { },
            modifier = Modifier.size(60.dp),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = AppRed),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(text = "🔒")
        }
    }
}