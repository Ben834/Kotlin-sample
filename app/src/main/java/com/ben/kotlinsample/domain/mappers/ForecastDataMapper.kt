package com.ben.kotlinsample.domain.mappers

import com.ben.kotlinsample.data.server.Forecast
import com.ben.kotlinsample.data.server.ForecastResult
import com.ben.kotlinsample.domain.model
import com.ben.kotlinsample.domain.model.ForecastList

/**
 * Classes need to be mapped from the data to the domain model
 */
class ForecastDataMapper{

    fun convertFromDataModel(zipCode: Long, forecast: ForecastResult) : ForecastList = with(forecast){
        return ForecastList(zipCode, forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list));
    }

    private fun convertForecastListToDomain(list: List<Forecast>):
            List<model.Forecast> {
        return list map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): model.Forecast = with(forecast){
        model.Forecast(dt * 1000,
                forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt(), generateIconUrl(forecast.weather[0].icon))
    }


    private fun generateIconUrl(iconCode: String) =  "http://openweathermap.org/img/w/$iconCode.png%22"
}
