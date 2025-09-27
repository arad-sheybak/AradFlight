package com.aradsheybak.flightticket.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TicketResponse(
    @field:Json(name = "tickets") val tickets: List<TicketDto>
)