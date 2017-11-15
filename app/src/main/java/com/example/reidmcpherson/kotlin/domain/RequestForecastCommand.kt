package com.example.reidmcpherson.kotlin.domain

import com.example.reidmcpherson.kotlin.ForecastRequest

class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode);
        return ForecastDataMapper().convertFromDataModle(forecastRequest.execute());
    }
}