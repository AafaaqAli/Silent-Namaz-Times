package com.aafaq.network.domain.usecases

import com.aafaq.network.ApiService
import com.aafaq.network.data.models.GeneralResponse
import com.aafaq.network.data.models.salah.Methods
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class GetCalendarByCityUseCase (
    private val apiService: ApiService
) {
    suspend fun execute(
        year: Int,
        month: Int?,
        city: String,
        state: String,
        country: String,
        method: Methods,
    ): Flow<GeneralResponse> {
        return flowOf(apiService.getCalendarByCity(
            year = year,
            month = month,
            country = country,
            state = state,
            city = city,
            method = method.numberValue
        ))
    }
}