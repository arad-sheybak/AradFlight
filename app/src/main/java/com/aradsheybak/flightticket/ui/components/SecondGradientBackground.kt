package com.aradsheybak.flightticket.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import com.aradsheybak.flightticket.R

@Composable
fun secondGradientBackground(): Brush {
    return Brush.radialGradient(
        colors = listOf(
            colorResource(R.color.purple_light),
            colorResource(R.color.base_color_purple)
        ),
//        center = Offset(0.5f, 0.5f),
        radius = 1000f
    )
}