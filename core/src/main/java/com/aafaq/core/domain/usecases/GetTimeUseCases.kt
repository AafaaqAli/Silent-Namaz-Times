package com.aafaq.core.domain.usecases

import com.aafaq.network.ApiService


class GetTimeUseCases (
    /**
     * TODO: Get DAO as well and
     * chose from where the data should come from
     * */
    private val apiService: ApiService,
    //private val dao: SalahDao
) {
    suspend fun execute(){}
}