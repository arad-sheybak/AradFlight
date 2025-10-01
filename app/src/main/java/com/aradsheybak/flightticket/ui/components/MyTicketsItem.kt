package com.aradsheybak.flightticket.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aradsheybak.flightticket.R
import com.aradsheybak.flightticket.domain.model.Ticket

@Composable
fun TicketItem(ticket: Ticket) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(280.dp)
            .height(130.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(R.color.base_color_purple))

    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "${ticket.departure.city} (${ticket.departure.airportCode}) → ${ticket.arrival.city} (${ticket.arrival.airportCode})",
                color = Color.White,
                fontSize = 18.sp
            )

            Text(
                text = "${ticket.departure.time} - ${ticket.arrival.time}",
                color = Color.Gray,
                fontSize = 14.sp
            )

            Text(
                text = ticket.airline,
                color = Color.White,
                fontSize = 14.sp
            )

            Text(
                text = "${ticket.price} ${ticket.currency}",
                color = Color.Green,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "${ticket.duration} • ${if (ticket.isDirect) "Direct" else "With Stops"}",
                color = Color.LightGray,
                fontSize = 12.sp
            )
        }
    }

}