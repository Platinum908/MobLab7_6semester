package com.example.trumpapp.ui.theme

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
fun Screen3(onBack: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        Image(
            painter = painterResource(id = R.drawable.liberty),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.7f),
            contentScale = ContentScale.Crop,
            alignment = BiasAlignment(-0.65f, 0f)
        )
        Column(modifier = Modifier.fillMaxSize()) {
            Screen3TopBar(onBack)
            Box(modifier = Modifier.weight(1f).fillMaxWidth()) {
                SideLabel()
                PlayBlock()
            }
            DonatePanel()
        }
    }
}

@Composable
private fun Screen3TopBar(onBack: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().statusBarsPadding().padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.clickable { onBack() }
        )
        Avatar()
    }
}

@Composable
private fun SideLabel() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterStart) {
        Box(
            modifier = Modifier
                .offset(y = (-50).dp)
                .padding(start = 8.dp)
                .width(24.dp)
                .height(110.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "FB TW INS",
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                softWrap = false,
                modifier = Modifier.wrapContentSize(unbounded = true).rotate(-90f)
            )
        }
    }
}

@Composable
private fun PlayBlock() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier.size(110.dp).background(Color(0x99445468), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "▶", color = Color.White, fontSize = 28.sp)
            }
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                text = "PROMISES MADE,\nPROMISES KEPT",
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun DonatePanel() {
    val selected = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppBlue, RoundedCornerShape(40.dp))
            .navigationBarsPadding()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Contribute Today!",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Text(text = "JOIN TRUMP", color = AppGray, fontSize = 12.sp)
        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            AmountButton(10, selected.value, { selected.value = 10 }, Modifier.weight(1f))
            Spacer(modifier = Modifier.width(8.dp))
            AmountButton(25, selected.value, { selected.value = 25 }, Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            AmountButton(50, selected.value, { selected.value = 50 }, Modifier.weight(1f))
            Spacer(modifier = Modifier.width(8.dp))
            AmountButton(100, selected.value, { selected.value = 100 }, Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth().height(72.dp),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = AppRed)
        ) {
            Text(text = "Donate", fontSize = 15.sp)
        }
    }
}

@Composable
private fun AmountButton(amount: Int, selected: Int, onClick: () -> Unit, modifier: Modifier) {
    val isSelected = selected == amount
    Button(
        onClick = onClick,
        modifier = modifier.height(62.dp),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Color(0x44FFFFFF) else Color.Transparent
        ),
        border = BorderStroke(1.dp, Color(0x66FFFFFF))
    ) {
        Text(text = amount.toString() + "$", fontSize = 15.sp)
    }
}