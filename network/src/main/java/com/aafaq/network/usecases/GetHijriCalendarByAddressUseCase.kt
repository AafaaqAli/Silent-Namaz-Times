package com.aafaq.network.usecases

import com.aafaq.network.ApiService
import com.aafaq.network.data.GeneralResponse
import com.aafaq.network.data.namaz.Location
import com.aafaq.network.domain.utils.NetworkConstants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class GetHijriCalendarByAddressUseCase (
    private val apiService: ApiService
) {
    suspend fun execute(
        year: Int,
        month: Int?,
        address: String,
        method: NetworkConstants.AlAdan.Methods,
    ): Flow<GeneralResponse> {
        return flowOf(apiService.getHijriCalendarByAddress(
            year = year,
            month = month,
            address = address,
            method.numberValue
        ))
    }
}