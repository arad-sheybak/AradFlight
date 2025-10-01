package com.aradsheybak.flightticket.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aradsheybak.flightticket.ui.screens.home.HomeScreen
import com.aradsheybak.flightticket.ui.screens.ProfileScreen
import com.aradsheybak.flightticket.ui.screens.SearchScreen
import com.aradsheybak.flightticket.ui.screens.home.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomNavItem.Home.route) {
                val viewModel: HomeViewModel = koinViewModel()

                HomeScreen()
            }
            composable(BottomNavItem.Search.route) { SearchScreen() }
            composable(BottomNavItem.Profile.route) { ProfileScreen() }
        }
    }
}