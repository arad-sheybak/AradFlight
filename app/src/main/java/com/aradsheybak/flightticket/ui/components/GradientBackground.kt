package com.aradsheybak.flightticket.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import com.aradsheybak.flightticket.R

@Composable
fun gradientBackground(): Brush{
    return Brush.verticalGradient(
        colors = listOf(
            colorResource(id = R.color.base_color_purple),
            colorResource(id = R.color.base_color_dark)
        )
    )

}