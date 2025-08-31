package com.aradsheybak.flightticket.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aradsheybak.flightticket.ui.screens.HomeScreen
import com.aradsheybak.flightticket.ui.screens.SplashScreen
import kotlinx.coroutines.delay

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {

        composable(Screen.Splash.route) {
            SplashScreen(navController)

        }

        composable(Screen.Home.route) {
            HomeScreen()
        }
//
//        composable(Screen.Login.route) {
//            LoginScreen()
//        }
    }
}