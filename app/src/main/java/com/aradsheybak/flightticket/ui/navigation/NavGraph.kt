package com.aradsheybak.flightticket.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aradsheybak.flightticket.ui.screens.HomeScreen
import com.aradsheybak.flightticket.ui.screens.LoginScreen
import com.aradsheybak.flightticket.ui.screens.onboardingPages.OnboardingScreen
import com.aradsheybak.flightticket.ui.screens.SplashScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {

        composable(Screen.Splash.route) {
            SplashScreen(navController)

        }
        composable(Screen.Onboarding.route) {
            OnboardingScreen(
                onFinish = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Onboarding.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Home.route) {
            HomeScreen()
        }


        composable(Screen.Login.route) {
            LoginScreen()
        }
    }
}