package com.aafaq.network.domain.usecases

import com.aafaq.network.ApiService
import com.aafaq.network.data.models.GeneralResponse
import com.aafaq.network.data.models.Salah.Location
import com.aafaq.network.data.models.Salah.Methods
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class GetCalendarUseCase (
    private val apiService: ApiService
) {
    suspend fun execute(
        year: Int,
        month: Int?,
        location: Location,
        method: Methods,
    ): Flow<GeneralResponse> {
        return flowOf(apiService.getCalendar(
            year = year,
            month = month,
            latitude = location.latitude ?: 0.0,
            longitude =  location.longitude ?: 0.0,
            method.numberValue
        ))
    }
}