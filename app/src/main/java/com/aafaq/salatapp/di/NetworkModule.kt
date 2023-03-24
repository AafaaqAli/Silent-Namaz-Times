package com.aafaq.salatapp.di

import com.aafaq.network.ApiService
import com.aafaq.network.data.repository.SalahNetworkRepositoryImp
import com.aafaq.network.domain.repository.SalahTimeNetworkRepository
import com.aafaq.network.domain.usecases.*
import com.aafaq.network.domain.utils.NetworkConstants
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    @Singleton
    @Provides
    fun providesMoshi() = Moshi.Builder().build()


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
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
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

    @Singleton
    @Provides
    fun providesHomeSalahNetworkRepository(useCases: UseCases): SalahTimeNetworkRepository {
        return SalahNetworkRepositoryImp(useCases)
    }
}