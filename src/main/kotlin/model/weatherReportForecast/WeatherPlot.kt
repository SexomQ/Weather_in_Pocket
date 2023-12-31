package model.weatherReportForecast

import org.jetbrains.kotlinx.dataframe.AnyFrame
import org.jetbrains.kotlinx.dataframe.api.toMap
import org.jetbrains.letsPlot.geom.geomLine
import org.jetbrains.letsPlot.ggsize
import org.jetbrains.letsPlot.letsPlot

class WeatherPlot: IPlotHumidity, IPlotTemperature, IPlotPrecipitation, IWeatherPlot {
    override fun plotTemperature(dataFrame: AnyFrame) {
        val plot = letsPlot(dataFrame.toMap()) { x = "time"; y = "temperature" } +
                geomLine() +
                ggsize(500, 500)

        plot.show()
    }

    override fun plotHumidity(dataFrame: AnyFrame) {
        val plot = letsPlot(dataFrame.toMap()) { x = "time"; y = "humidity" } +
                geomLine() +
                ggsize(500, 500)

        plot.show()
    }

    override fun plotPrecipitation(dataFrame: AnyFrame) {
        val plot = letsPlot(dataFrame.toMap()) { x = "time"; y = "precipitation" } +
                geomLine() +
                ggsize(500, 500)

        plot.show()
    }

    override fun plot(dataFrame: AnyFrame) {
        println("Wait for the plots to load")
        plotTemperature(dataFrame)
        plotHumidity(dataFrame)
        plotPrecipitation(dataFrame)
    }


}