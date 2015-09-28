package com.ben.kotlinsample.data.db

import com.ben.kotlinsample.extensions.parseList
import com.ben.kotlinsample.extensions.parseOpt
import org.jetbrains.anko.db.select
import java.util.*

class ForecastDb(val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance,
                 val dataMapper : DbDataMapper = DbDataMapper()){

    fun requestForecastByZipCode(zipCode: Long, date: Long) = forecastDbHelper.use{

        //First, we need to request the daily forecast
        val dailyRequest = "${DayForecastTable.CITY_ID} = ? " +
                "AND ${DayForecastTable.DATE} >= ?"


        val dailyForecast = select(DayForecastTable.NAME)
                            .whereSimple(dailyRequest, zipCode.toString(), date.toString())
                            .parseList { DayForecast(HashMap(it)) }

        //parseOpt returns a nullable object. It will be the case the first time we do the query
        val city = select(CityForecastTable.NAME)
                    .whereSimple("${CityForecastTable.ID} = ?", zipCode.toString())
                    .parseOpt {CityForecast(HashMap(it), dailyForecast)}

        if(city != null) dataMapper.convertToDomain(city) else null

    }

}