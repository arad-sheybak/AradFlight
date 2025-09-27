package com.aradsheybak.flightticket.data.source.local

import android.content.Context
import com.aradsheybak.flightticket.data.model.TicketResponse
import com.squareup.moshi.Moshi

class TicketLocalDataSource(
    private val context: Context,
    private val moshi: Moshi
) {
    fun loadTickets(): TicketResponse {
        val json = context.assets.open("ticket_list.json").bufferedReader().use { it.readText() }
        val adapter = moshi.adapter(TicketResponse::class.java)
        return adapter.fromJson(json) ?: TicketResponse(emptyList())
    }
}