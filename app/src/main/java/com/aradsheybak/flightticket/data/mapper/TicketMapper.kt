package com.aradsheybak.flightticket.data.mapper

import com.aradsheybak.flightticket.data.model.TicketDto
import com.aradsheybak.flightticket.domain.model.Ticket

fun TicketDto.toDomain(): Ticket {
    return Ticket(
        id = id,
        from = from,
        to = to,
        date = date,
        time = time,
        airline = airline,
        price = price
    )
}