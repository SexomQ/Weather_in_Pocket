package model.weatherReportHourly

interface IHourlyWeatherFactory {
    fun createHourlyElement(type: String): IHourlyWeather
}