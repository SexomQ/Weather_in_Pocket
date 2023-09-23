package model.weatherReportForecast

import org.jetbrains.kotlinx.dataframe.AnyFrame

interface IPlotTemperature {
    fun plotTemperature(dataFrame: AnyFrame)
}