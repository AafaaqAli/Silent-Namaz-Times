package com.aafaq.network.domain.utils

sealed class NetworkConstants {
    object AlAdan {
        private const val API_VERSION = "v1"
        const val BASE_URL = "http://api.aladhan.com/${API_VERSION}/"

        /**
         * Refer to https://aladhan.com/prayer-times-api
         * */
        object EndPoints{
            const val GET_TIME_CALENDAR = "/calendar/{year}/{month}"
            const val GET_TIME_CALENDAR_BY_ADDRESS ="/calendarByAddress/{year}/{month}"
            const val GET_TIME_CALENDAR_BY_CITY = "/calendarByCity/{year}/{month}"
            const val GET_TIME_HIJRI_CALENDAR_BY_ADDRESS = "/hijriCalendarByAddress/{year}/{month}"
            const val GET_TIME_HIJRI_CALENDAR_BY_CITY = "/hijriCalendarByCity/{year}/{month}"
            const val GET_PRAYER_TIME_CALCULATION_METHODS = "/methods"
            const val GET_PRAYER_TIMING = "/timings/{date}"
            const val GET_PRAYER_TIMING_BY_ADDRESS = "/timingsByAddress/{date}"
            const val GET_PRAYER_TIMING_BY_CITY = "/timingsByCity/{date}"
        }
    }
}