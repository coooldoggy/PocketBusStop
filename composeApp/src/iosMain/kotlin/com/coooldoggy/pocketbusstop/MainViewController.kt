package com.coooldoggy.pocketbusstop

import androidx.compose.ui.window.ComposeUIViewController
import androidx.compose.runtime.remember
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.coooldoggy.pocketbusstop.navigation.AppNavigator

fun MainViewController() = ComposeUIViewController {
    val lifecycleOwner = DefaultComponentContext(LifecycleRegistry())
    val navigator = remember { createAppNavigator(lifecycleOwner) }
    App(navigator)
}

private fun createAppNavigator(componentContext: ComponentContext): AppNavigator {
    return AppNavigator(componentContext)
}