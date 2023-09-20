package weatherReport

import org.jetbrains.kotlinx.dataframe.AnyFrame

interface IPlotTemperature {
    fun plotTemperature(dataFrame: AnyFrame)
}