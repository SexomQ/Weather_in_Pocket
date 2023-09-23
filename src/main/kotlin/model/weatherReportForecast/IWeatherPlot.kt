package model.weatherReportForecast

import org.jetbrains.kotlinx.dataframe.AnyFrame

interface IWeatherPlot {
    fun plot(dataFrame: AnyFrame)
}