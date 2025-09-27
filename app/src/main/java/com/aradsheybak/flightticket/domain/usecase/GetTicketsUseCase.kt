package com.aradsheybak.flightticket.domain.usecase

import com.aradsheybak.flightticket.domain.repository.TicketRepository

class GetTicketsUseCase(
    private val repository: TicketRepository
) {
    suspend operator fun invoke() = repository.getTickets()
}