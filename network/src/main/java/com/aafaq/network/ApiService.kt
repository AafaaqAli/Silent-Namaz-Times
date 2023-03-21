package com.aafaq.network

import com.aafaq.network.data.GeneralResponse
import com.aafaq.network.domain.utils.NetworkConstants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * TODO - add data objects and responses for each api
 * */
interface ApiService {
    @GET(NetworkConstants.AlAdan.EndPoints.GET_TIME_CALENDAR)
    suspend fun getCalendar(
        @Path("year") year: Int,
        @Path("month") month: Int?,
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("method") method: Double,
    ): GeneralResponse

    @GET(NetworkConstants.AlAdan.EndPoints.GET_TIME_CALENDAR_BY_ADDRESS)
    suspend fun getCalendarByAddress(
        @Query("address") address: String,
        @Path("month") month: Int?,
        @Path("year") year: Int,
        @Query("method") method: Double
    ): GeneralResponse

    @GET(NetworkConstants.AlAdan.EndPoints.GET_TIME_CALENDAR_BY_CITY)
    suspend fun getCalendarByCity(
        @Query("city") city: String,
        @Query("country") country: String,
        @Query("state") state: String,
        @Path("month") month: Int?,
        @Path("year") year: Int,
        @Query("method") method: Double,
    ): GeneralResponse

    @GET(NetworkConstants.AlAdan.EndPoints.GET_TIME_HIJRI_CALENDAR_BY_ADDRESS)
    suspend fun getHijriCalendar(
        @Path("month") month: Int?,
        @Path("year") year: Int,
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("method") method: Double,
    ): GeneralResponse

    @GET(NetworkConstants.AlAdan.EndPoints.GET_TIME_HIJRI_CALENDAR_BY_ADDRESS)
    suspend fun getHijriCalendarByAddress(
        @Path("month") month: Int?,
        @Path("year") year: Int,
        @Query("address") address: String,
        @Query("method") method: Double,
    ): GeneralResponse

    @GET(NetworkConstants.AlAdan.EndPoints.GET_TIME_HIJRI_CALENDAR_BY_CITY)
    suspend fun getHijriCalendarByCity(
        @Query("city") city: String,
        @Query("country") country: String,
        @Query("state") state: String,
        @Path("month") month: Int?,
        @Path("year") year: Int,
        @Query("method") method: Double
    ): GeneralResponse

    /**
     * Not being used currently
     * */
    @GET(NetworkConstants.AlAdan.EndPoints.GET_PRAYER_TIME_CALCULATION_METHODS)
    suspend fun getPrayerTimeCalculationMethods()

    @GET(NetworkConstants.AlAdan.EndPoints.GET_PRAYER_TIMING)
    suspend fun getPrayerTime(
        @Path("date") date: String,
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("method") method: Double,
    ): GeneralResponse


    @GET(NetworkConstants.AlAdan.EndPoints.GET_PRAYER_TIMING_BY_ADDRESS)
    suspend fun getPrayerTimeByAddress(
        @Query("date") date: String,
        @Query("address") address: String,
        @Query("method") method: Double,
    ): GeneralResponse

    @GET(NetworkConstants.AlAdan.EndPoints.GET_PRAYER_TIMING_BY_CITY)
    suspend fun getPrayerTimeByCity(
        @Query("date") date: String,
        @Query("city") city: String,
        @Query("country") country: String,
        @Query("state") state: String,
        @Query("method") method: Double,
    ): GeneralResponse
}