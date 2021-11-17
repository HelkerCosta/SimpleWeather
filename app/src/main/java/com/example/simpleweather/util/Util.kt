package com.example.simpleweather.util

import android.util.Log
import com.example.simpleweather.R
import java.util.*

fun convertHour(hour: Int, pm: Int): String{


    if (hour == 0){
        return "12am"
    }

    if(pm == 1 && hour > 12){
        return "${hour - 12}pm"
    }

    return "${hour}am"
}

fun getMonthDay(dt: Long): Int{
    val date = Calendar.getInstance()
    date.timeInMillis = dt * 1000

    return date.get(Calendar.DAY_OF_MONTH)
}


fun getWeekDay(dt: Long): Int{
    val date = Calendar.getInstance()
    date.timeInMillis = dt * 1000

    return date.get(Calendar.DAY_OF_WEEK)
}

fun getTimeAmPm(dt: Long): String{
    val date = Calendar.getInstance()
    date.timeInMillis = dt * 1000

    Log.d("Test", date.get(Calendar.DATE).toString())
    Log.d("Test", date.toString())

    return convertHour(date.get(Calendar.HOUR_OF_DAY), date.get(Calendar.AM_PM))
}

fun getWeatherIcon(icon: String): Int{
  return when(icon)
    {
        "01d" -> (R.drawable.ic_sunny)
        "02d" -> (R.drawable.ic_partly_cloudy)
        "03d" -> (R.drawable.ic_clounds_day)
        "04d" -> (R.drawable.ic_clounds_day)
        "09d" -> (R.drawable.ic_rainy)
        "10d" -> (R.drawable.ic_rainy)
        "11d" -> (R.drawable.ic_thuderstorm)
        "13d" -> (R.drawable.ic_snow)
        "50d" -> (R.drawable.ic_fog)
        "01n" -> (R.drawable.ic_clear_night)
        "02n" -> (R.drawable.ic_partly_cloudy_night)
        "03n" -> (R.drawable.ic_cloudy_night)
        "04n" -> (R.drawable.ic_cloudy_night)
        "09n" -> (R.drawable.ic_rainy_night)
        "10n" -> (R.drawable.ic_rainy_night)
        "11n" -> (R.drawable.ic_thuderstorm_night)
        "13n" -> (R.drawable.ic_snow_night)
        "50n" -> (R.drawable.ic_fog_night)

        else -> (R.drawable.ic_launcher_background)
    }
}

fun getDateFormat(day: Int, weekDay: Int): String{

    if(weekDay > 7 || weekDay < 0 || day < 1 || day > 31){
        return ""
    }

     val week = hashMapOf<Int, String>()
    week[7] = "Sun"
    week[1] = "Mon"
    week[2] = "Tue"
    week[3] = "Wed"
    week[4] = "Thu"
    week[5] = "Fri"
    week[6] = "Sat"

    return "${day} ${week[weekDay]}"
}

