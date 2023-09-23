package model.weatherReportHourly

import org.jetbrains.kotlinx.dataframe.AnyFrame

class HourlyWeatherService {

    class Facade {
        val temp = HourlyWeatherFactory.createHourlyElement("temperature")
        val humid = HourlyWeatherFactory.createHourlyElement("humidity")
        val prec = HourlyWeatherFactory.createHourlyElement("precipitation")

        fun getTemperature(data: AnyFrame): String {
            return temp.getLastData(data)
        }

        fun getHumidity(data: AnyFrame): String {
            return humid.getLastData(data)
        }

        fun getPrecipitation(data: AnyFrame): String {
            return prec.getLastData(data)
        }
    }

    fun getWeatherLastHour(data: AnyFrame): WeatherLastHourBuilder {
        val facade = Facade()

        return WeatherLastHourBuilder.Builder()
            .setTemperature(temp = facade.getTemperature(data))
            .setHumidity(humid = facade.getHumidity(data))
            .setPrecipitation(prec = facade.getPrecipitation(data))
            .build()
    }
}