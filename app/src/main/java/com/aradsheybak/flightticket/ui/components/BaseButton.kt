package com.aradsheybak.flightticket.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.aradsheybak.flightticket.R

@Composable
fun BaseButton(
    text: String,
    fontSize: TextUnit = 24.sp,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = colorResource(R.color.purple_200),
    textColor: Color = Color.White,
    cornerRadius: Dp = 16.dp,
    borderColor: Color = Color.Transparent,
    borderWidth: Dp = 0.dp
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = textColor
        ),
        shape = RoundedCornerShape(cornerRadius),
        border = if (borderWidth > 0.dp) BorderStroke(borderWidth, borderColor) else null,

        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            fontSize=fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}