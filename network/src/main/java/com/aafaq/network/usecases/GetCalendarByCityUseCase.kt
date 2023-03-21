package com.aafaq.network.usecases

import com.aafaq.network.ApiService
import com.aafaq.network.data.GeneralResponse
import com.aafaq.network.data.namaz.Location
import com.aafaq.network.domain.utils.NetworkConstants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class GetCalendarByCityUseCase (
    private val apiService: ApiService
) {
    suspend fun execute(
        year: String,
        month: String,
        city: String,
        method: NetworkConstants.AlAdan.Methods,
    ): Flow<GeneralResponse> {
        return flowOf(apiService.getCalendarByCity(
            year = year,
            month = month,
            city = city,
            method = method.numberValue
        ))
    }
}