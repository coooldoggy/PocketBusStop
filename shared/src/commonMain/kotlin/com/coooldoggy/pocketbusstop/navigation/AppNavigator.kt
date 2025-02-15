package com.coooldoggy.pocketbusstop.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.*
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import kotlinx.serialization.Serializable

class AppNavigator(
    componentContext: ComponentContext
) : ComponentContext by componentContext {
    private val navigation = StackNavigation<Config>()
    val stack = childStack(
        source = navigation,
        initialConfiguration = Config.Home,
        childFactory = ::createChild
    )

    private fun createChild(config: Config, componentContext: ComponentContext): Screen {
        return when (config) {
            is Config.Splash -> Screen.Splash
            is Config.Home -> Screen.Home
            is Config.WidgetSetup -> Screen.WidgetSetup
            is Config.Settings -> Screen.Settings
        }
    }

    fun navigateTo(screen: Screen) {
        navigation.push(
            when (screen) {
                is Screen.Splash -> Config.Splash
                is Screen.Home -> Config.Home
                is Screen.WidgetSetup -> Config.WidgetSetup
                is Screen.Settings -> Config.Settings
            }
        )
    }

    @Parcelize
    @Serializable
    sealed class Config : Parcelable {
        @Serializable object Splash : Config()
        @Serializable object Home : Config()
        @Serializable object WidgetSetup : Config()
        @Serializable object Settings : Config()
    }
}