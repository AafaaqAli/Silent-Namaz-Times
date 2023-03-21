package com.aafaq.network.domain.utils

sealed class NetworkConstants {
    object AlAdan {
        private const val API_VERSION = "v1"
        const val BASE_URL = "http://api.aladhan.com/${API_VERSION}"

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

        enum class Methods(val methodName: String, val numberValue: Double){
            JAFARI("Shia Ithna-Ansari", 0.0),
            KARACHI("University of Islamic Sciences, Karachi", 1.0),
            NORTH_AMERICA("Islamic Society of North America", 2.0),
            MWL("Muslim World League", 3.0),
            MAKKAH("Umm Al-Qura University, Makkah", 4.0),
            EGYPT("Egyptian General Authority of Survey", 5.0),
            TEHRAN("Institute of Geophysics, University of Tehran", 6.0),
            GULF_REGION("Gulf Region", 7.0),
            KUWAIT("Kuwait", 8.0),
            QATAR("Qatar", 9.0),
            SINGAPORE("Majlis Ugama Islam Singapura, Singapore", 10.0),
            FRANCE("Union Organization islamic de France", 11.0),
            TURKEY("Diyanet İşleri Başkanlığı, Turkey", 12.0),
            RUSSIA("Spiritual Administration of Muslims of Russia", 13.0),
            MOONSIGHTING("Moonsighting Committee Worldwide", 14.0),
            DUBAI("Dubai", 15.0),
        }
    }
}