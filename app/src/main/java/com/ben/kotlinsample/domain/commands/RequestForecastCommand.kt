package com.ben.kotlinsample.domain.commands

import com.ben.kotlinsample.data.ForecastRequest
import com.ben.kotlinsample.domain.mappers.ForecastDataMapper
import com.ben.kotlinsample.domain.model.ForecastList

public class RequestForecastCommand(val zipcode: String) : Command<ForecastList>{

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipcode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}