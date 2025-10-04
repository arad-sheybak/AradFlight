package com.aradsheybak.flightticket.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.aradsheybak.flightticket.R
import com.aradsheybak.flightticket.ui.components.BaseButton
import com.aradsheybak.flightticket.ui.components.TicketItem
import com.aradsheybak.flightticket.ui.components.gradientBackground
import com.aradsheybak.flightticket.util.getCurrentDate
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = koinViewModel()) {
    Ui(viewModel)
}

@Composable
private fun Ui(viewModel: HomeViewModel = koinViewModel()) {
    val scrollState = rememberScrollState()
    var from by remember { mutableStateOf("") }
    var to by remember { mutableStateOf("") }
    val tickets by viewModel.tickets.collectAsState()
    val date = remember { getCurrentDate() }

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
                    imgNotification,
                    imgBadgeNotification,
                    txtDate,
                    txtLocation,
                    boxFrom,
                    boxTo,
                    imgSwitch,
                    rowBoxDetails,
                    searchBtn,
                    txtMyTicket,
                    lzyRowMyTickets) = createRefs()

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
                    painter = painterResource(R.drawable.ic_notification),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(45.dp)
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
                    text = date,
                    color = colorResource(R.color.white),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.constrainAs(txtDate) {
                        top.linkTo(parent.top, margin = 24.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })

                Row(
                    horizontalArrangement = Arrangement.Center,
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

                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .height(60.dp)
                        .background(
                            color = Color.Black.copy(alpha = 0.5f),
                            shape = RoundedCornerShape(
                                topEnd = 16.dp,
                                topStart = 16.dp
                            )
                        )
                        .constrainAs(boxFrom) {
                            top.linkTo(imgBg.bottom)
                            bottom.linkTo(imgBg.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                ) {
                    TextField(
                        value = from,
                        onValueChange = { from = it },
                        label = { Text("From") },
                        placeholder = { Text("Gorgan, Iran") },
                        singleLine = true,
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            cursorColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            errorIndicatorColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                color = Color.Transparent,
                                shape = RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp)
                            )
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .height(60.dp)
                        .background(
                            color = Color.Black.copy(alpha = 0.5f),
                            shape = RoundedCornerShape(
                                bottomEnd = 16.dp,
                                bottomStart = 16.dp
                            )
                        )
                        .constrainAs(boxTo) {
                            top.linkTo(boxFrom.bottom, margin = 8.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                ) {
                    TextField(
                        value = to,
                        onValueChange = { to = it },
                        label = { Text("To") },
                        placeholder = { Text("Gorgan, Iran") },
                        singleLine = true,
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            cursorColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            errorIndicatorColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                color = Color.Transparent,
                                shape = RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp)
                            )
                    )
                }
                Image(
                    painter = painterResource(R.drawable.ic_switch_from_to),
                    contentDescription = null,
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .clickable {
                        }
                        .rotate(90f)
                        .background(colorResource(R.color.placeholder_color))
                        .constrainAs(imgSwitch) {
                            top.linkTo(boxFrom.bottom)
                            bottom.linkTo(boxTo.top)
                            end.linkTo(boxFrom.end)
                            start.linkTo(boxFrom.end)

                        }
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .height(80.dp)
                        .constrainAs(rowBoxDetails) {
                            top.linkTo(boxTo.bottom, margin = 16.dp)
                            start.linkTo(boxTo.start)
                            end.linkTo(boxTo.end)
                        }) {
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color.Black.copy(alpha = 0.5f),
                                shape = RoundedCornerShape(
                                    topStart = 16.dp,
                                    bottomStart = 16.dp
                                )
                            )
                            .weight(1f)
                            .height(80.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 8.dp, vertical = 8.dp),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Departure",
                                fontSize = 12.sp,
                                color = colorResource(R.color.placeholder_color)
                            )
                            Text(
                                text = "Wen,Sep 24",
                                color = colorResource(R.color.white),
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(vertical = 8.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color.Black.copy(alpha = 0.5f),
                            )
                            .weight(1f)
                            .height(80.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 8.dp, vertical = 8.dp),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "class",
                                fontSize = 12.sp,
                                color = colorResource(R.color.placeholder_color)
                            )
                            Text(
                                text = "Business",
                                color = colorResource(R.color.white),
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(vertical = 8.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color.Black.copy(alpha = 0.5f),
                                shape = RoundedCornerShape(
                                    topEnd = 16.dp,
                                    bottomEnd = 16.dp
                                )
                            )
                            .weight(1f)
                            .height(80.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 8.dp, vertical = 8.dp),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Passengers",
                                fontSize = 12.sp,
                                color = colorResource(R.color.placeholder_color)
                            )
                            Text(
                                text = "2 Adults",
                                color = colorResource(R.color.white),
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(vertical = 8.dp)
                            )
                        }
                    }

                }

                BaseButton(
                    text = "Search",
                    fontSize = 20.sp,
                    onClick = {},
                    backgroundColor = colorResource(R.color.blue_light),
                    borderWidth = 1.dp,
                    borderColor = colorResource(R.color.stroke_purple),
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .height(48.dp)
                        .constrainAs(searchBtn) {
                            top.linkTo(rowBoxDetails.bottom, margin = 16.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                )

                Text(
                    text = "My Tickets",
                    color = colorResource(R.color.white),
                    fontSize = 20.sp,
                    modifier = Modifier
                        .constrainAs(txtMyTicket) {
                            top.linkTo(searchBtn.bottom, margin = 16.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                        }
                )

                LazyRow(
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .constrainAs(lzyRowMyTickets) {
                            top.linkTo(txtMyTicket.bottom, margin = 8.dp)
                            start.linkTo(txtMyTicket.start)
                            end.linkTo(parent.end, margin = 16.dp)
                        }
                ) {
                    items(tickets) { ticket ->
                        TicketItem(ticket = ticket)
                    }
                }
            }
        }
    }
}