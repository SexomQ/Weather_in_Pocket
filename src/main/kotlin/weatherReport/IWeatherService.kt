package weatherReport

import org.jetbrains.kotlinx.dataframe.AnyFrame

interface IWeatherService {
    fun getReportOneDay():WeatherReport
    suspend fun getData(): AnyFrame
}