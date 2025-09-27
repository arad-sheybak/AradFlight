package com.aradsheybak.flightticket.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TicketDto(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "from") val from: String,
    @field:Json(name = "to") val to: String,
    @field:Json(name = "date") val date: String,
    @field:Json(name = "time") val time: String,
    @field:Json(name = "airline") val airline: String,
    @field:Json(name = "price") val price: String
)
