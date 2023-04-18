package com.aafaq.network.domain.usecases

import com.aafaq.network.ApiService
import com.aafaq.network.data.models.GeneralResponse
import com.aafaq.network.data.models.salah.Location
import com.aafaq.network.data.models.salah.Methods
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class GetPrayerTimeUseCase (
    private val apiService: ApiService
) {
    suspend fun execute(
        date: String,
        location: Location,
        method: Methods
    ): Flow<GeneralResponse> {
        return flowOf(apiService.getPrayerTime(
            date = date,
            latitude = location.latitude ?: 0.0,
            longitude = location.longitude ?: 0.0,
            method = method.numberValue
        ))
    }
}