package com.ben.kotlinsample.data

import com.google.gson.Gson
import java.net.URL

internal class ForecastRequest(val zipcode: String){

    //Object shared between all instances of the class
    companion object {
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7&q="
    }

    fun execute(): ForecastResult{
        val forecastJsonStr = URL(URL + zipcode).readText();
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }


}