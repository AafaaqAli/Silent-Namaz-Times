package com.aafaq.network.usecases

import com.aafaq.network.ApiService
import com.aafaq.network.data.GeneralResponse
import com.aafaq.network.data.namaz.Location
import com.aafaq.network.domain.utils.NetworkConstants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class GetHijriCalendarByCityUseCase (
    private val apiService: ApiService
) {
    suspend fun execute(
        city: String,
        country: String,
        state: String,
        year: String,
        month: String,
        method: NetworkConstants.AlAdan.Methods,
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