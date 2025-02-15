package com.coooldoggy.pocketbusstop

import androidx.compose.runtime.*
import com.coooldoggy.pocketbusstop.navigation.AppNavigator
import com.coooldoggy.pocketbusstop.screens.HomeScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(rootComponent: AppNavigator) {
    var showHome by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    //splash -> Home
    LaunchedEffect(Unit) {
        coroutineScope.launch {
            delay(2000)
            showHome = true
        }
    }

    if (showHome) {
        HomeScreen(rootComponent)
    } else {
//        SplashScreen()
    }
}