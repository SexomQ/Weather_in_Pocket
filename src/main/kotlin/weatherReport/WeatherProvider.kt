package weatherReport

import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.jetbrains.kotlinx.dataframe.AnyFrame
import org.jetbrains.kotlinx.dataframe.api.toDataFrame

class WeatherProvider: IWeatherProvider {

    @Serializable
    data class HourlyData(
        val time: List<String>,
        @SerialName("temperature_2m") val temperature: List<Double>,
        @SerialName("relativehumidity_2m") val humidity: List<Double>,
        val precipitation: List<Double>
    )

    @Serializable
    data class WeatherData(val hourly: HourlyData)

    override suspend fun transformData(): AnyFrame {
        val jsonString = apiCall()
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

    override suspend fun apiCall(): String {
        val client = HttpClient()
        val data = client.get<String>("https://api.open-meteo.com/v1/forecast?latitude=47.0251&longitude=28.7975&hourly=temperature_2m,relativehumidity_2m,precipitation&timezone=Europe%2FBerlin&models=best_match")

        return data
    }

}