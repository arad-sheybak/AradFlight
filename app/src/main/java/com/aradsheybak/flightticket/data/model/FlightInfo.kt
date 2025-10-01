package com.aradsheybak.flightticket.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FlightInfo(
    @field:Json(name = "duration")
    val duration: String,

    @field:Json(name = "isDirect")
    val isDirect: Boolean
)