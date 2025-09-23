package com.aradsheybak.flightticket.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.aradsheybak.flightticket.R
import com.aradsheybak.flightticket.ui.components.gradientBackground

@Composable
fun HomeScreen() {
    Ui()
}

@Composable
@Preview
private fun Ui() {
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBackground())
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(state = scrollState)
        ) {

            ConstraintLayout {
                val (imgBg,
                    imgProfile,
                    imgNotification,
                    imgBadgeNotification,
                    txtDate,
                    txtLocation,
                    boxTickerOptions) = createRefs()

                Image(
                    painter = painterResource(R.drawable.bg_airplane_home),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .alpha(0.5f)
                        .constrainAs(imgBg) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                )

                Image(
                    painter = painterResource(R.drawable.ic_user_profile),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .clickable {
                        }
                        .constrainAs(imgProfile) {
                            top.linkTo(parent.top, margin = 16.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                        }
                )

                Image(
                    painter = painterResource(R.drawable.ic_notification),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .clickable {
                        }
                        .background(colorResource(R.color.base_color_dark))
                        .padding(10.dp)
                        .constrainAs(imgNotification) {
                            top.linkTo(parent.top, margin = 16.dp)
                            end.linkTo(parent.end, margin = 16.dp)
                        }
                )

                Image(
                    painter = painterResource(R.drawable.ic_badge_notification),
                    contentDescription = null,
                    modifier = Modifier
                        .size(16.dp)
                        .constrainAs(imgBadgeNotification) {
                            top.linkTo(imgNotification.top)
                            end.linkTo(imgNotification.end)
                        }
                )

                Text(
                    text = stringResource(R.string.date_in_home),
                    color = colorResource(R.color.white),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.constrainAs(txtDate) {
                        top.linkTo(parent.top, margin = 24.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })

                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                    .constrainAs(txtLocation) {
                    top.linkTo(txtDate.bottom, margin = 8.dp)
                    start.linkTo(txtDate.start)
                    end.linkTo(txtDate.end)
                }) {
                    Image(
                        painter = painterResource(R.drawable.ic_location_home),
                        contentDescription = null,
                        modifier = Modifier
                            .size(12.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = stringResource(R.string.location_home),
                        color = colorResource(R.color.white),
                        fontSize = 16.sp,
                    )
                }




            }
        }
    }
}