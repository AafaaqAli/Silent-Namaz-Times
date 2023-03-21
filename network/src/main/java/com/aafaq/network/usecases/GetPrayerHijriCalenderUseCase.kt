package com.aafaq.network.usecases

import com.aafaq.network.ApiService
import com.aafaq.network.data.GeneralResponse
import com.aafaq.network.data.namaz.Location
import com.aafaq.network.domain.utils.NetworkConstants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class GetPrayerHijriCalenderUseCase(
    private val apiService: ApiService
) {
    suspend fun execute(
        year: String,
        month: String,
        location: Location,
        method: NetworkConstants.AlAdan.Methods,
    ): Flow<GeneralResponse> {
        return flowOf(
            apiService.getHijriCalendar(
                year = year,
                month = month,
                latitude = location.latitude ?: 0.0,
                longitude = location.longitude ?: 0.0,
                method = method.numberValue
            )
        )
    }
}