package com.aafaq.network.data.repository

import com.aafaq.network.data.models.GeneralResponse
import com.aafaq.network.data.models.salah.Location
import com.aafaq.network.data.models.salah.Methods
import com.aafaq.network.domain.repository.SalahTimeNetworkRepository
import com.aafaq.network.domain.usecases.UseCases
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class SalahNetworkRepositoryImp(
    private val useCases: UseCases
): SalahTimeNetworkRepository {
    override suspend fun getCalendarByAddress(
        year: Int,
        month: Int?,
        address: String,
        method: Methods
    ): Flow<GeneralResponse> = useCases.getCalendarByAddress.execute(year, month, address, method)

    override suspend fun getCalendarByCity(
        year: Int,
        month: Int?,
        city: String,
        state: String,
        country: String,
        method: Methods
    ): Flow<GeneralResponse> = useCases.getCalendarByCity.execute(year, month, city, state, country, method)

    override suspend fun getCalendar(
        year: Int,
        month: Int?,
        location: Location,
        method: Methods
    ): Flow<GeneralResponse> = useCases.getCalendar.execute(year, month, location, method)

    override suspend fun getHijriCalendarByAddress(
        year: Int,
        month: Int?,
        address: String,
        method: Methods
    ): Flow<GeneralResponse> = useCases.getHijriCalendarByAddress.execute(year, month, address, method)

    override suspend fun getHijriCalendarByCity(
        city: String,
        country: String,
        state: String,
        year: Int,
        month: Int,
        method: Methods
    ): Flow<GeneralResponse> = useCases.getHijriCalendarByCity.execute(city, country, state, year, month, method)

    override suspend fun getHijriCalendar(
        year: Int,
        month: Int?,
        location: Location,
        method: Methods
    ): Flow<GeneralResponse> = useCases.getHijriCalendar.execute(year, month, location, method)

    override suspend fun getPrayerTimeByAddress(
        date: String,
        address: String,
        method: Double
    ): Flow<GeneralResponse> = useCases.getPrayerTimeByAddress.execute(date, address, method)

    override suspend fun getPrayerTimeByCity(
        date: String,
        city: String,
        country: String,
        state: String,
        method: Methods
    ): Flow<GeneralResponse> = useCases.getPrayerTimeByCity.execute(date, city, country, state, method)

    override suspend fun getPrayerTime(
        date: String,
        location: Location,
        method: Methods
    ): Flow<GeneralResponse> = useCases.getPrayerTime.execute(date, location, method)
}