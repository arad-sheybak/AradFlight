package com.aradsheybak.flightticket.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aradsheybak.flightticket.domain.model.Ticket
import com.aradsheybak.flightticket.domain.usecase.GetTicketsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getTicketsUseCase: GetTicketsUseCase
): ViewModel()  {
    private val _tickets = MutableStateFlow<List<Ticket>>(emptyList())
    val tickets: StateFlow<List<Ticket>> = _tickets

    init {
        loadTickets()
    }

    private fun loadTickets() {
        viewModelScope.launch {
            _tickets.value = getTicketsUseCase()
        }
    }
}