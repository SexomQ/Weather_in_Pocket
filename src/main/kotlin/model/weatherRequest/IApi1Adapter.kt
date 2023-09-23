package model.weatherRequest

import org.jetbrains.kotlinx.dataframe.AnyFrame

interface IApi1Adapter {
    suspend fun getData(refresh:Boolean): String
    suspend fun transformData(): AnyFrame
}