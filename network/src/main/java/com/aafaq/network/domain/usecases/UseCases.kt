package com.aafaq.network.domain.usecases

data class UseCases(
    val getCalendarByAddress: GetCalendarByAddressUseCase,
    val getCalendarByCity: GetCalendarByCityUseCase,
    val getCalendar: GetCalendarUseCase,
    val getHijriCalendarByAddress: GetHijriCalendarByAddressUseCase,
    val getHijriCalendarByCity: GetHijriCalendarByCityUseCase,
    val getHijriCalendar: GetPrayerHijriCalenderUseCase,
    val getPrayerTimeByAddress: GetPrayerTimeByAddressUseCase,
    val getPrayerTimeByCity: GetPrayerTimeByCityUseCase,
    val getPrayerTime: GetPrayerTimeUseCase
)