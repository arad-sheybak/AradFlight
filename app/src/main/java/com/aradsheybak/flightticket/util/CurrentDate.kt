package com.aradsheybak.flightticket.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
fun getCurrentDate(): String{
    val currentDate =
        LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("EEEE, dd MMM yyyy", Locale.ENGLISH)
    return currentDate.format(formatter)

}

