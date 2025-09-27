package com.aradsheybak.flightticket.di

import com.aradsheybak.flightticket.data.repository.TicketRepositoryImpl
import com.aradsheybak.flightticket.data.source.local.TicketLocalDataSource
import com.aradsheybak.flightticket.domain.repository.TicketRepository
import com.aradsheybak.flightticket.domain.usecase.GetTicketsUseCase
import com.squareup.moshi.Moshi
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Moshi
    single { Moshi.Builder().build() }

    // local data source (uses Android context to read assets)
    single { TicketLocalDataSource(androidContext(), get()) } // constructor(context: Context, moshi: Moshi)

    // repository (impl -> domain interface)
    single<TicketRepository> { TicketRepositoryImpl(get()) } // TicketRepositoryImpl(localDataSource = get())

    // useCase
    factory { GetTicketsUseCase(get()) }

    // viewModel
    viewModel { TicketViewModel(get()) } // TicketViewModel(getTicketsUseCase = get())
}