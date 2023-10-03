package model.weatherReportHourly

object HourlyWeatherFactory: IHourlyWeatherFactory {
    override fun createHourlyElement(type: String): IHourlyWeather {
        return when (type) {
            "temperature" -> HourlyTemperature()
            "precipitation" -> HourlyPrecipitation()
            "humidity" -> HourlyHumidity()
            else -> throw IllegalArgumentException("Unknown type: $type")
        }
    }
}