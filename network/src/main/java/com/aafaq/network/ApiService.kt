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
        @Path("year") year: String,
        @Path("month") date: String,
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("method") method: Double,
    ): GeneralResponse

    @GET(NetworkConstants.AlAdan.EndPoints.GET_TIME_CALENDAR_BY_ADDRESS)
    suspend fun getCalendarByAddress(
        @Path("year") year: String,
        @Path("month") date: String,
        @Query("address") address: String,
        @Query("method") method: Double,
    ): GeneralResponse

    @GET(NetworkConstants.AlAdan.EndPoints.GET_TIME_CALENDAR_BY_CITY)
    suspend fun getCalendarByCity(
        @Path("year") year: String,
        @Path("month") date: String,
        @Query("city") city: String,
        @Query("method") method: String,
    ): GeneralResponse

    @GET(NetworkConstants.AlAdan.EndPoints.GET_TIME_HIJRI_CALENDAR_BY_ADDRESS)
    suspend fun getHijriCalendarByAddress(
        @Path("year") year: String,
        @Path("month") date: String,
        @Query("address") address: String,
        @Query("method") method: Double,
    ): GeneralResponse

    @GET(NetworkConstants.AlAdan.EndPoints.GET_TIME_HIJRI_CALENDAR_BY_CITY)
    suspend fun getHijriCalendarByCity(
        @Path("year") year: String,
        @Path("month") date: String,
        @Query("city") city: String,
        @Query("country") country: String,
        @Query("method") method: Double,
    ): GeneralResponse

    @GET(NetworkConstants.AlAdan.EndPoints.GET_PRAYER_TIME_CALCULATION_METHODS)
    suspend fun getPrayerTimeCalculationMethods()

    @GET(NetworkConstants.AlAdan.EndPoints.GET_PRAYER_TIMING)
    suspend fun getPrayerTime(
        @Path("date") year: String,
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("method") method: Double,
    ): GeneralResponse


    @GET(NetworkConstants.AlAdan.EndPoints.GET_PRAYER_TIMING_BY_ADDRESS)
    suspend fun getPrayerTimeByAddress(
        @Path("date") year: String,
        @Query("address") address: String,
    ): GeneralResponse

    @GET(NetworkConstants.AlAdan.EndPoints.GET_PRAYER_TIMING_BY_CITY)
    suspend fun getPrayerTimeByCity(
        @Path("date") year: String,
        @Query("city") city: String,
        @Query("method") method: Double,
    ): GeneralResponse
}