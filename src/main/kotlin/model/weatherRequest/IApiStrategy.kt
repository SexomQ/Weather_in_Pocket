package model.weatherRequest

import org.jetbrains.kotlinx.dataframe.AnyFrame

interface IApiStrategy {
    suspend fun transformData(): AnyFrame
}