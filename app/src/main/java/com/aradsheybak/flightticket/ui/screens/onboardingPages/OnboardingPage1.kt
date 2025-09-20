package com.aradsheybak.flightticket.ui.screens.onboardingPages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aradsheybak.flightticket.R
import com.aradsheybak.flightticket.ui.components.gradientBackground

@Composable
fun OnboardingPage1(
    onNext: () -> Unit,
    onBack: () -> Unit,
    onFinish: () -> Unit
) {
    Ui(onNext = onNext, onFinish)


}

@Composable
@Preview
private fun Ui(
    onNext: () -> Unit = {},
    onFinish: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                gradientBackground()
            )
    ) {
        Text(
            text = stringResource(R.string.skip),
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.W500,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .windowInsetsPadding(WindowInsets.statusBars)
                .padding(start = 0.dp, top = 10.dp, end = 20.dp, bottom = 0.dp)
                .clickable {
                    onFinish()
                }

        )
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(150.dp))
                Image(
                    painter = painterResource(R.drawable.ic_onboarding),
                    contentDescription = "onboarding image",
                    modifier = Modifier.requiredSize(250.dp)
                )
                Spacer(Modifier.height(60.dp))
                Text(
                    text = stringResource(R.string.onboarding1_title),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.W700
                )
                Spacer(Modifier.height(60.dp))
                Text(
                    text = stringResource(R.string.onboarding1_desc),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W400,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 20.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_circle_fill),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                    Icon(
                        painter = painterResource(R.drawable.ic_circle_empty),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                    Icon(
                        painter = painterResource(R.drawable.ic_circle_empty),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                }

                Text(
                    text = stringResource(R.string.next),
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(20.dp)
                        .clickable {
                            onNext()
                        }
                )
            }

        }
    }
}
