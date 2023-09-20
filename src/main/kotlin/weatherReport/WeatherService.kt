package weatherReport

import org.jetbrains.kotlinx.dataframe.AnyFrame

class WeatherService(val weatherProvider: IWeatherProvider):IWeatherService {
    override fun getReportOneDay(): WeatherReport {
        return WeatherReport.Builder()
            .setTemperature(temp = 23.4f)
            .setHumidity(humid = 0.8f)
            .setPrecipitation(prec = 0.2f)
            .build()
    }

    override suspend fun getData():AnyFrame {
        val forcasting = weatherProvider.transformData()

        return forcasting
    }
}