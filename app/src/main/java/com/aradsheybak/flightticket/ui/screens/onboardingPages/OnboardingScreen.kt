package com.aradsheybak.flightticket.ui.screens.onboardingPages

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun OnboardingScreen(onFinish: () -> Unit) {
    var currentPage by remember { mutableIntStateOf(0) }

    Crossfade(targetState = currentPage) { page ->
        when (page) {
            0 -> OnboardingPage1 { currentPage++ }
            1 -> OnboardingPage2 { currentPage++ }
            2 -> OnboardingPage3 { onFinish() }
        }
    }
}