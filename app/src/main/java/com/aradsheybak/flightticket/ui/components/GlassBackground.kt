package com.aradsheybak.flightticket.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import androidx.compose.ui.geometry.Offset

@Composable
fun GlassBackground(
    modifier: Modifier = Modifier,
    heightFraction: Float = 0.5f,
    cornerRadius: Float = 24f,
    blurRadius: Float = 16f
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(heightFraction)
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color.White.copy(alpha = 0.15f),
                        Color.White.copy(alpha = 0.05f)
                    ),
                    center = Offset.Unspecified,
                    radius = 600f
                ),
                shape = RoundedCornerShape(
                    topStart = cornerRadius.dp,
                    topEnd = cornerRadius.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                )
            )
            .blur(blurRadius.dp)
            .drawBehind {
                val strokeWidth = 2.dp.toPx()
                val radiusPx = cornerRadius.dp.toPx()

                drawLine(
                    color = Color.White.copy(alpha = 0.4f),
                    start = Offset(radiusPx, 0f),
                    end = Offset(size.width - radiusPx, 0f),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )

                drawLine(
                    color = Color.White.copy(alpha = 0.3f),
                    start = Offset(0f, radiusPx),
                    end = Offset(0f, size.height),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )

                drawLine(
                    color = Color.White.copy(alpha = 0.3f),
                    start = Offset(size.width, radiusPx),
                    end = Offset(size.width, size.height),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )
            }
    )
}
