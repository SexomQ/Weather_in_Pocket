package weatherReport

import org.jetbrains.kotlinx.dataframe.AnyFrame

interface IPlotHumidity {
    fun plotHumidity(dataFrame: AnyFrame)
}