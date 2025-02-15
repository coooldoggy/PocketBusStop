package com.coooldoggy.pocketbusstop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.DefaultComponentContext
import com.coooldoggy.pocketbusstop.navigation.AppNavigator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root = AppNavigator(DefaultComponentContext(lifecycle))
        setContent {
            App(root)
        }
    }
}
