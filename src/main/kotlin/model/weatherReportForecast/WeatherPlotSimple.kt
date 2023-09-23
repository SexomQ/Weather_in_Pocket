package model.weatherReportForecast

import org.jetbrains.kotlinx.dataframe.AnyFrame
import org.jetbrains.kotlinx.dataframe.api.toMap
import org.jetbrains.letsPlot.geom.geomLine
import org.jetbrains.letsPlot.ggsize
import org.jetbrains.letsPlot.letsPlot

class WeatherPlotSimple: IPlotTemperature, IWeatherPlot {
    override fun plotTemperature(dataFrame: AnyFrame) {
        println("Plotting data frame")
        val plot = letsPlot(dataFrame.toMap()) { x = "time"; y = "temperature" } +
                geomLine() +
                ggsize(500, 500)

        plot.show()
    }

    override fun plot(dataFrame: AnyFrame) {
        plotTemperature(dataFrame)
    }


}