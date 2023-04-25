package com.aafaq.core.domain.repository

interface ISalahDataOperationsRepository {

    /**
     ** REMEMBER: Never use same Entities for both Persistence and API
     ** TODO: Create Separate entities for Room and APIs
     **/
    suspend fun getPrayerTimes(){}
}