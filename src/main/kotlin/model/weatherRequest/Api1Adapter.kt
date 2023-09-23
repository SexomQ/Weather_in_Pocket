package model.weatherRequest

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.jetbrains.kotlinx.dataframe.AnyFrame
import org.jetbrains.kotlinx.dataframe.api.toDataFrame

class Api1Adapter(private val api1Caller: IApi1Caller): IApi1Adapter, IApiStrategy {
    var apiResponse = ""

    @Serializable
    data class HourlyData(
        val time: List<String>,
        @SerialName("temperature_2m") val temperature: List<Double>,
        @SerialName("relativehumidity_2m") val humidity: List<Double>,
        val precipitation: List<Double>
    )

    @Serializable
    data class WeatherData(val hourly: HourlyData)

    override suspend fun getData(refresh:Boolean): String {
        if ((refresh) or (apiResponse == "")) {
            apiResponse = api1Caller.apiCall()
        }
        return apiResponse
    }

    override suspend fun transformData(): AnyFrame {
        val jsonString = getData(true)
        val weatherData: WeatherData = Json { ignoreUnknownKeys = true }.decodeFromString(jsonString)

        val time = weatherData.hourly.time
        val temperature = weatherData.hourly.temperature
        val humidity = weatherData.hourly.humidity
        val precipitation = weatherData.hourly.precipitation

        val df: AnyFrame = mapOf(
            "time" to time,
            "temperature" to temperature,
            "humidity" to humidity,
            "precipitation" to precipitation
        ).toDataFrame()

        return df
    }
}