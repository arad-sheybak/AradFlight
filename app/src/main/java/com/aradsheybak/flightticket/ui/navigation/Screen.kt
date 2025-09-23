package com.aradsheybak.flightticket.ui.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Onboarding: Screen(route = "onboarding")
    object Home : Screen("home")
    object Login : Screen("login")

    object Signup: Screen("signup")

    object Main: Screen("main")
}