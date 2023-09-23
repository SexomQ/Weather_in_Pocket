package model.weatherReportForecast

import org.jetbrains.kotlinx.dataframe.AnyFrame

interface IPlotPrecipitation {
    fun plotPrecipitation(dataFrame: AnyFrame)
}