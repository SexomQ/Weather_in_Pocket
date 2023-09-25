package model.weatherReportHourly

import org.jetbrains.kotlinx.dataframe.AnyFrame

class HourlyWeatherService {

    class Facade {
        val temp = HourlyWeatherFactory.createHourlyElement("temperature")
        val humid = HourlyWeatherFactory.createHourlyElement("humidity")
        val prec = HourlyWeatherFactory.createHourlyElement("precipitation")

        val composite = CompositeWeatherElement(listOf(temp, humid, prec))

        fun getCompositeData(data: AnyFrame): List<String> {
            return composite.getLastData(data).split(", ")
        }
    }

    fun getWeatherLastHour(data: AnyFrame): WeatherLastHourBuilder {
        val facade = Facade()
        val compositeData = facade.getCompositeData(data)

        return WeatherLastHourBuilder.Builder()
            .setTemperature(temp = compositeData[0])
            .setHumidity(humid = compositeData[1])
            .setPrecipitation(prec = compositeData[2])
            .build()
    }
}