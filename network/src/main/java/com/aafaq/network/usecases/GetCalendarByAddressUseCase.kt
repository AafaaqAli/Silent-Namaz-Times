package com.aafaq.network.usecases

import com.aafaq.network.ApiService
import com.aafaq.network.data.GeneralResponse
import com.aafaq.network.domain.utils.NetworkConstants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class GetCalendarByAddressUseCase (
    private val apiService: ApiService
) {
    suspend fun execute(
        year: String,
        date: String,
        address: String,
        method: NetworkConstants.AlAdan.Methods,
    ): Flow<GeneralResponse> {
        return flowOf(apiService.getCalendarByAddress(
            year = year,
            date = date,
            address = address,
            method = method.numberValue
        ))
    }
}