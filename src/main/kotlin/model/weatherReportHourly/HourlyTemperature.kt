package model.weatherReportHourly

import org.jetbrains.kotlinx.dataframe.AnyFrame
import org.jetbrains.kotlinx.dataframe.api.filter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class HourlyTemperature: IHourlyWeather {
    override fun getLastData(df:AnyFrame): String {
        val current = LocalDateTime.now()
        val time_exact = current.minusMinutes(current.minute.toLong())
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
        val formatted = time_exact.format(formatter)

        val df_filtered = df.filter { it["time"] == formatted }
        val temp = df_filtered["temperature"][0].toString()
        return temp
    }
}