package model.weatherReportHourly

import org.jetbrains.kotlinx.dataframe.AnyFrame

interface ICompositeFacade {
    fun getCompositeData(data: AnyFrame): List<String>
}