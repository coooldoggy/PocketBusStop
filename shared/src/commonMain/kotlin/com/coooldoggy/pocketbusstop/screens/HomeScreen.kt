package com.coooldoggy.pocketbusstop.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import com.coooldoggy.pocketbusstop.navigation.AppNavigator
import com.coooldoggy.pocketbusstop.navigation.Screen

@Composable
fun HomeScreen(navigator: AppNavigator) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center) {
        Text(text = "🏠 홈 화면", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { navigator.navigateTo(Screen.WidgetSetup) }) {
            Text("위젯 설정 화면으로 이동")
        }
        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { navigator.navigateTo(Screen.Settings) }) {
            Text("설정 화면으로 이동")
        }
    }
}