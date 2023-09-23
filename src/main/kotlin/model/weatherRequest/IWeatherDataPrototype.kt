package model.weatherRequest

interface IWeatherDataPrototype {

    fun clone(): IWeatherDataPrototype
}