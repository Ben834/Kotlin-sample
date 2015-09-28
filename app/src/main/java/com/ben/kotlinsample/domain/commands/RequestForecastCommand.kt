package com.ben.kotlinsample.domain.commands

import com.ben.kotlinsample.data.server.ForecastRequest
import com.ben.kotlinsample.domain.mappers.ForecastDataMapper
import com.ben.kotlinsample.domain.model.ForecastList

class RequestForecastCommand(private val zipcode: Long) : Command<ForecastList>{

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipcode)
        return ForecastDataMapper().convertFromDataModel(zipcode, forecastRequest.execute())
    }

}