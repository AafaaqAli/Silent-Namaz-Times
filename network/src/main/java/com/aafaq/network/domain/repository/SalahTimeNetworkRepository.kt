package com.aafaq.network.domain.repository

import com.aafaq.network.data.models.GeneralResponse
import com.aafaq.network.data.models.salah.Location
import com.aafaq.network.data.models.salah.Methods
import kotlinx.coroutines.flow.Flow

interface SalahTimeNetworkRepository {
    suspend fun getCalendarByAddress(
        year: Int,
        month: Int?,
        address: String,
        method: Methods
    ): Flow<GeneralResponse>

    suspend fun getCalendarByCity(
        year: Int,
        month: Int?,
        city: String,
        state: String,
        country: String,
        method: Methods,
    ): Flow<GeneralResponse>

    suspend fun getCalendar(
        year: Int,
        month: Int?,
        location: Location,
        method: Methods,
    ): Flow<GeneralResponse>

    suspend fun getHijriCalendarByAddress(
        year: Int,
        month: Int?,
        address: String,
        method: Methods,
    ): Flow<GeneralResponse>

    suspend fun getHijriCalendarByCity(
        city: String,
        country: String,
        state: String,
        year: Int,
        month: Int,
        method: Methods
    ): Flow<GeneralResponse>

    suspend fun getHijriCalendar(
        year: Int,
        month: Int?,
        location: Location,
        method: Methods,
    ): Flow<GeneralResponse>

    suspend fun getPrayerTimeByAddress(
        date: String,
        address: String,
        method: Double,
    ): Flow<GeneralResponse>

    suspend fun getPrayerTimeByCity(
        date: String,
        city: String,
        country: String,
        state: String,
        method: Methods,
    ): Flow<GeneralResponse>

    suspend fun getPrayerTime(
        date: String,
        location: Location,
        method: Methods
    ): Flow<GeneralResponse>
}