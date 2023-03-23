package com.aafaq.salatapp.di

import com.aafaq.network.ApiService
import com.aafaq.network.domain.usecases.*
import com.aafaq.network.domain.utils.NetworkConstants
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

object NetworkModule {
    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(NetworkConstants.AlAdan.BASE_URL)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun providesSalahNetworkRepositoryUseCases(apiService: ApiService): UseCases{
        return UseCases(
            GetCalendarByAddressUseCase(apiService),
            GetCalendarByCityUseCase(apiService),
            GetCalendarUseCase(apiService),
            GetHijriCalendarByAddressUseCase(apiService),
            GetHijriCalendarByCityUseCase(apiService),
            GetPrayerHijriCalenderUseCase(apiService),
            GetPrayerTimeByAddressUseCase(apiService),
            GetPrayerTimeByCityUseCase(apiService),
            GetPrayerTimeUseCase(apiService)
        )
    }
}