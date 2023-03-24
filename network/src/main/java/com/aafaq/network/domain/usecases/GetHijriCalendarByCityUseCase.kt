package com.aafaq.network.domain.usecases

import com.aafaq.network.ApiService
import com.aafaq.network.data.models.GeneralResponse
import com.aafaq.network.data.models.salah.Methods
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class GetHijriCalendarByCityUseCase (
    private val apiService: ApiService
) {
    suspend fun execute(
        city: String,
        country: String,
        state: String,
        year: Int,
        month: Int,
        method: Methods
    ): Flow<GeneralResponse> {
        return flowOf(apiService.getHijriCalendarByCity(
            year = year,
            month = month,
            city = city,
            country = country,
            state = state,
            method = method.numberValue
        ))
    }
}