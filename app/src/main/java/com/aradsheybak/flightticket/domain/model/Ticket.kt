package com.aradsheybak.flightticket.domain.model

data class Ticket(
    val id: String,
    val from: String,
    val to: String,
    val date: String,
    val time: String,
    val airline: String,
    val price: String
)