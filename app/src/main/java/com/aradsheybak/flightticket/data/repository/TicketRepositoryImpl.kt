package com.aradsheybak.flightticket.data.repository

import com.aradsheybak.flightticket.data.mapper.toDomain
import com.aradsheybak.flightticket.data.source.local.TicketLocalDataSource
import com.aradsheybak.flightticket.domain.model.Ticket
import com.aradsheybak.flightticket.domain.repository.TicketRepository


class TicketRepositoryImpl(
    private val localDataSource: TicketLocalDataSource
) : TicketRepository {

    override suspend fun getTickets(): List<Ticket> {
        return localDataSource.loadTickets().tickets.map { it.toDomain() }
    }
}