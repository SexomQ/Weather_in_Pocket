package model.weatherReportHourly

import org.jetbrains.kotlinx.dataframe.AnyFrame

class CompositeWeatherElement(private val elements: List<IHourlyWeather>) : IHourlyWeather {
    override fun getLastData(df: AnyFrame): String {
        return elements.joinToString(", ") { it.getLastData(df) }
    }
}