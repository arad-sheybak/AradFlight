package com.aradsheybak.flightticket.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TicketDto(
    @field:Json(name = "id")
    val id: Int,

    @field:Json(name = "airline")
    val airline: String,

    @field:Json(name = "price")
    val price: Double,

    @field:Json(name = "currency")
    val currency: String,

    @field:Json(name = "departure")
    val departure: AirportInfo,

    @field:Json(name = "arrival")
    val arrival: AirportInfo,

    @field:Json(name = "flight")
    val flight: FlightInfo
)


