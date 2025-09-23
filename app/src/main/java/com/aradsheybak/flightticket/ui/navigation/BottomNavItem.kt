package com.aradsheybak.flightticket.ui.navigation

import com.aradsheybak.flightticket.R

sealed class BottomNavItem (val route: String, val title: String, val icon: Int) {
    object Home : BottomNavItem("home", "Home", R.drawable.ic_home)
    object Search : BottomNavItem("search", "Search", R.drawable.ic_search)
    object Profile : BottomNavItem("profile", "Profile", R.drawable.ic_profile)
}