package com.aradsheybak.flightticket.data.mapper

import com.aradsheybak.flightticket.data.model.TicketDto
import com.aradsheybak.flightticket.domain.model.AirportInfoDomain
import com.aradsheybak.flightticket.domain.model.Ticket

fun TicketDto.toDomain(): Ticket {
    return Ticket(
        id = id,
        airline = airline,
        price = price,
        currency = currency,
        departure = AirportInfoDomain(
            airportCode = departure.airportCode,
            city = departure.city,
            country = departure.country,
            time = departure.time
        ),
        arrival = AirportInfoDomain(
            airportCode = arrival.airportCode,
            city = arrival.city,
            country = arrival.country,
            time = arrival.time
        ),
        duration = flight.duration,
        isDirect = flight.isDirect
    )
}