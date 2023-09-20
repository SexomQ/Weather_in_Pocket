package weatherReport

import org.jetbrains.kotlinx.dataframe.AnyFrame


interface IWeatherProvider {
    suspend fun apiCall(): String
    suspend fun transformData(): AnyFrame
//    suspend fun toDataframe(dataFrame: Map<String, List<Any?>>): DataFrame
}