package com.ben.kotlinsample.data.server

/** All the data classes for representing the data request responses **/

internal data class ForecastResult(val city: City, val list: List<Forecast>)

internal data class City(val id: Long, val name: String, val coord: Coordinates, val country: String,
                val population: Int)

internal data class Coordinates(val long: Float, val lat: Float)

internal data class Forecast(val dt: Long, val temp: Temperature, val pressure: Float, val humidity: Int,
                    val weather: List<Weather>, val speed: Float, val deg: Int, val clous: Int,
                    val rain: Float)

internal data class Temperature(val day: Float, val min: Float, val max: Float, val night: Float,
                       val eve: Float, val morn: Float)

internal data class Weather(val id: Long, val main: String, val description: String, val icon: String)