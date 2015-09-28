package com.ben.kotlinsample.domain.model

/** The domain data classes **/
internal data class ForecastList(val id: Long, val city: String, val country: String, val dailyForecast: List<Forecast>){

    fun get(position: Int) = dailyForecast.get(position)
    fun size() = dailyForecast.size()

}

internal data class Forecast(val date: Long, val description: String, val high: Int, val low: Int,
                    val iconUrl: String)
