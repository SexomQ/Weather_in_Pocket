package model.refreshManager

import org.jetbrains.kotlinx.dataframe.AnyFrame

interface IWeatherObserver {
    fun update(df: AnyFrame)
}