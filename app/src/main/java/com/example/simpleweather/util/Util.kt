package com.example.simpleweather.util

fun convertHour(hour: Int, pm: Int): String{


    if (hour == 0){
        return "12am"
    }

    if(pm == 1 && hour > 12){
        return "${hour - 12}pm"
    }

    return "${hour}am"
}
