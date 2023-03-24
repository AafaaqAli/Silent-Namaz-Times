package com.aafaq.network.domain.usecases

import com.aafaq.network.ApiService
import com.aafaq.network.data.models.GeneralResponse
import com.aafaq.network.data.models.salah.Methods
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class GetPrayerTimeByCityUseCase (
    private val apiService: ApiService
) {
    suspend fun execute(
        date: String,
        city: String,
        country: String,
        state: String,
        method: Methods,
    ): Flow<GeneralResponse> {
        return flowOf(apiService.getPrayerTimeByCity(
            date = date,
            city = city,
            country = country,
            state = state,
            method = method.numberValue
        ))
    }
}