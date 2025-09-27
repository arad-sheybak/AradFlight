package com.aradsheybak.flightticket.domain.repository

import com.aradsheybak.flightticket.domain.model.Ticket

interface TicketRepository {
    suspend fun getTickets(): List<Ticket>

}