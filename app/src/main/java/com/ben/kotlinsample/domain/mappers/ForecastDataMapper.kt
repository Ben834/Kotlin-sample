package com.ben.kotlinsample.domain.mappers

import com.ben.kotlinsample.data.*
import com.ben.kotlinsample.domain.model
import com.ben.kotlinsample.domain.model.ForecastList
import java.text.DateFormat
import java.util.*

/**
 * Classes need to be mapped from the data to the domain model
 */
public class ForecastDataMapper{

    public fun convertFromDataModel(forecast: ForecastResult) : ForecastList{
        return ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list));
    }

    private fun convertForecastListToDomain(list: List<Forecast>):
            List<model.Forecast> {
        return list map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): model.Forecast {
        return model.Forecast(convertDate(forecast.dt),
                forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt(), generateIconUrl(forecast.weather[0].icon))
    }


    private fun generateIconUrl(iconCode: String) : String = "http://openweathermap.org/img/w/$iconCode.png%22"

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM,
                Locale.getDefault())
        return df.format(date * 1000)
    }
}
