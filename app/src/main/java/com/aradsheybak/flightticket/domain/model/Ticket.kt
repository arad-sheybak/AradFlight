package com.aradsheybak.flightticket.domain.model

data class Ticket(
    val id: Int,
    val airline: String,
    val price: Double,
    val currency: String,
    val departure: AirportInfoDomain,
    val arrival: AirportInfoDomain,
    val duration: String,
    val isDirect: Boolean
)

data class AirportInfoDomain(
    val airportCode: String,
    val city: String,
    val country: String,
    val time: String
)