package com.example.trumpapp.ui.theme

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.graphics.drawscope.Stroke
import com.example.trumpapp.R

@Composable
fun Screen2(onAddToCart: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().background(AppLightGray)) {
        CapCard()

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(horizontal = 22.dp, vertical = 24.dp)
        ) {
            FeaturesList()
            Spacer(modifier = Modifier.height(24.dp))
            QuantityRow()
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = onAddToCart,
                modifier = Modifier.fillMaxWidth().height(72.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(containerColor = AppBlue)
            ) {
                Text(text = "ADD TO CART")
            }
        }
    }
}

@Composable
private fun CapCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp))
            .statusBarsPadding()
            .padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "TRUMP", color = AppRed, fontWeight = FontWeight.Bold, fontSize = 12.sp)
            Avatar()
        }
        Spacer(modifier = Modifier.height(26.dp))
        Text(
            text = "Official Make America\nGreat Again 45th",
            color = AppDark,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            lineHeight = 17.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(14.dp))
        Text(text = "PRESIDENT HAT — RED", color = AppGray, fontSize = 10.sp)
        Spacer(modifier = Modifier.height(28.dp))

        CapGallery()

        Text(
            text = "$34.00",
            color = AppRed,
            fontSize = 11.sp,
            textDecoration = TextDecoration.LineThrough
        )
        Text(text = "$30.00", color = AppDark, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun CapGallery() {
    val caps = listOf(R.drawable.cap1, R.drawable.cap2, R.drawable.cap3, R.drawable.cap4)
    val index = remember { mutableStateOf(0) }

    Box(modifier = Modifier.fillMaxWidth().height(265.dp)) {
        Image(
            painter = painterResource(id = caps[index.value]),
            contentDescription = null,
            modifier = Modifier.fillMaxSize().padding(start = 52.dp, end = 44.dp),
            contentScale = ContentScale.Fit
        )
        SaleBadge(modifier = Modifier.align(Alignment.TopStart).padding(start = 44.dp))
        Column(
            modifier = Modifier.align(Alignment.CenterStart).padding(start = 4.dp, top = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = null,
                tint = AppBlue,
                modifier = Modifier
                    .clickable { index.value = (index.value - 1 + caps.size) % caps.size }
                    .padding(4.dp)
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = null,
                tint = AppBlue,
                modifier = Modifier
                    .clickable { index.value = (index.value + 1) % caps.size }
                    .padding(4.dp)
            )
        }
        Column(
            modifier = Modifier.align(Alignment.CenterEnd).padding(end = 14.dp, top = 30.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            for (cap in caps) {
                Image(
                    painter = painterResource(id = cap),
                    contentDescription = null,
                    modifier = Modifier.size(28.dp)
                )
            }
        }
    }
}

@Composable
private fun SaleBadge(modifier: Modifier) {
    Box(
        modifier = modifier
            .size(80.dp)
            .drawBehind {
                drawCircle(
                    color = AppRed,
                    style = Stroke(
                        width = 1.5.dp.toPx(),
                        pathEffect = PathEffect.dashPathEffect(
                            floatArrayOf(3.dp.toPx(), 4.dp.toPx())
                        )
                    )
                )
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "SALE",
            color = AppRed,
            fontSize = 12.sp,
            modifier = Modifier.rotate(-30f)
        )
    }
}

@Composable
private fun FeaturesList() {
    Column(modifier = Modifier.fillMaxWidth().padding(start = 26.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Feature("Embroidered 45\non right side", Modifier.weight(1f))
            Feature("Embroidered\nTrump 2020 logo\non back", Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(28.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Feature("Plastic Snap\nClosure", Modifier.weight(1f))
            Feature("Proudly Made in\nUSA", Modifier.weight(1f))
        }
    }
}

@Composable
private fun Feature(text: String, modifier: Modifier) {
    Row(modifier = modifier) {
        Text(text = "•", color = AppRed, fontSize = 12.sp, lineHeight = 14.sp)
        Spacer(modifier = Modifier.width(6.dp))
        Text(text = text, color = AppGray, fontSize = 11.sp, lineHeight = 14.sp)
    }
}

@Composable
private fun QuantityRow() {
    val count = remember { mutableStateOf(1) }
    val expanded = remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "QTY", color = AppDark, fontWeight = FontWeight.Bold, fontSize = 12.sp)
        Spacer(modifier = Modifier.width(40.dp))
        Box {
            Row(
                modifier = Modifier
                    .width(165.dp)
                    .height(58.dp)
                    .border(1.dp, AppBorder, RoundedCornerShape(29.dp))
                    .clickable { expanded.value = true }
                    .padding(horizontal = 36.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = count.value.toString(), color = AppDark, fontSize = 12.sp)
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    tint = AppRed
                )
            }
            DropdownMenu(
                expanded = expanded.value,
                onDismissRequest = { expanded.value = false }
            ) {
                for (n in 0..10) {
                    DropdownMenuItem(
                        text = { Text(text = n.toString()) },
                        onClick = {
                            count.value = n
                            expanded.value = false
                        }
                    )
                }
            }
        }
    }
}