package com.aafaq.network.usecases

import com.aafaq.network.ApiService
import com.aafaq.network.data.GeneralResponse
import com.aafaq.network.data.namaz.Location
import com.aafaq.network.domain.utils.NetworkConstants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import retrofit2.http.Query

class GetPrayerTimeByCityUseCase (
    private val apiService: ApiService
) {
    suspend fun execute(
        date: String,
        city: String,
        country: String,
        state: String,
        method: NetworkConstants.AlAdan.Methods,
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