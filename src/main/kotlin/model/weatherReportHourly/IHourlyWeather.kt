package model.weatherReportHourly

import org.jetbrains.kotlinx.dataframe.AnyFrame

interface IHourlyWeather {
    fun getLastData(df:AnyFrame): String
}