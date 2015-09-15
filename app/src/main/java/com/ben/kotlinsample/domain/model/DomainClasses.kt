package com.ben.kotlinsample.domain.model

/** The domain data classes **/
data class ForecastList(val city: String, val country: String, val dailyForecast:List<Forecast>){

    fun get(position: Int) = dailyForecast.get(position)
    fun size() = dailyForecast.size()

}

data class Forecast(val date: String, val description: String, val high: Int, val low: Int,
                    val iconUrl: String)
