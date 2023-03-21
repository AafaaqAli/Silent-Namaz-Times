package com.aafaq.network.usecases

import com.aafaq.network.ApiService
import com.aafaq.network.data.GeneralResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class GetPrayerTimeByAddressUseCase(
    private val apiService: ApiService
) {
    suspend fun execute(
        date: String,
        address: String,
        method: Double,
    ): Flow<GeneralResponse> {
        return flowOf(
            apiService.getPrayerTimeByAddress(
                date = date,
                address = address,
                method = method
            )
        )
    }
}