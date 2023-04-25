package com.aafaq.core.domain.utils

import android.annotation.SuppressLint
import android.content.Context
import com.aafaq.core.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.concurrent.TimeUnit



enum class DateOutputFormat(var format: String) {
    FORMAT_ONE("YYYY.MM.DDD"),
    FORMAT_TWO("YYYY/MM/DDD"),
    FORMAT_THREE("dd MMM yyyy"),
    FORMAT_FOUR("MMMM dd yyyy"),
    FORMAT_API_CALL("DD-MM-YYYY")
}

enum class TimeOutputFormat(var format: String) {
    FORMAT_ONE("HH:mm:ss z"),
    FORMAT_TWO("YYYY/MM/DDD"),
    FORMAT_THREE("ddd MMM yyyy"),
    FORMAT_FOUR("MMMM dd yyyy"),
}

@SuppressLint("SimpleDateFormat")
fun Long.getCurrentDate(format: DateOutputFormat?): String {
    format?.let {
        return SimpleDateFormat(it.format).format(Date(this))
    } ?: run {
        return SimpleDateFormat(DateOutputFormat.FORMAT_THREE.format).format(Date(this))
    }
}

@SuppressLint("SimpleDateFormat")
fun Long.getCurrentTime(format: TimeOutputFormat?): String {
    format?.let {
        return SimpleDateFormat(it.format).format(Date(this))
    } ?: run {
        return SimpleDateFormat(TimeOutputFormat.FORMAT_THREE.format).format(Date(this))
    }
}

@SuppressLint("SimpleDateFormat")
fun Long.getDate(dateFormat: DateOutputFormat): String?{
    return try{
        SimpleDateFormat(dateFormat.format).format(this)
    }catch (e: Exception){
        e.printStackTrace()
        null
    }
}

fun Context.getCalculatedHourString(salah: String, salahTime: Long): String {
    /**
     * If salah time is ahead of current time that means
     * there is time in next salah
     * */
    val systemTime = Calendar.getInstance().timeInMillis
    val isUpcoming = salahTime > systemTime

    val diff = if (isUpcoming) { salahTime - systemTime } else { systemTime - salahTime }

    val minute = TimeUnit.MILLISECONDS.toSeconds(diff) / 60
    val hour = minute / 60

    val timeInSalah = "$hour:$minute"

    return if (isUpcoming) {
        this.getString(R.string.SALAH_UPCOMING, timeInSalah, salah)
    } else {
        this.getString(R.string.SALAH_LATE, salah, timeInSalah)
    }
}