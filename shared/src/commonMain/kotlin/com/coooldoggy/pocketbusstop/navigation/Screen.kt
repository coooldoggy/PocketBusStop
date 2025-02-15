package com.coooldoggy.pocketbusstop.navigation

@Serializable
sealed class Screen(val route: String) {
    @Serializable object Splash : Screen("splash")
    @Serializable object Home : Screen("home")
    @Serializable object WidgetSetup : Screen("widget_setup")
    @Serializable object Settings : Screen("settings")
}