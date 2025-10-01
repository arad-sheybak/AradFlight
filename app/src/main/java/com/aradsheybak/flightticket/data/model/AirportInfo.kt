package com.aradsheybak.flightticket.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AirportInfo(
    @field:Json(name = "airportCode")
    val airportCode: String,

    @field:Json(name = "city")
    val city: String,

    @field:Json(name = "country")
    val country: String,

    @field:Json(name = "time")
    val time: String
)