package com.ben.kotlinsample.domain.commands

import com.ben.kotlinsample.data.server.ForecastRequest
import com.ben.kotlinsample.domain.mappers.ForecastDataMapper
import com.ben.kotlinsample.domain.model.ForecastList

class RequestForecastCommand(private val zipcode: String) : Command<ForecastList>{

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipcode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}