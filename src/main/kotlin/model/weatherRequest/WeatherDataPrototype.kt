package model.weatherRequest

import org.jetbrains.kotlinx.dataframe.AnyFrame

data class WeatherDataPrototype (private var strategy: IApiStrategy, var dataframe:AnyFrame) : IWeatherDataPrototype{
    fun setStrategy(strategy: IApiStrategy) {
        this.strategy = strategy
    }

    suspend fun transformData(): AnyFrame {
        this.dataframe = strategy.transformData()
        return dataframe
    }

    override fun clone(): WeatherDataPrototype {
        return copy()
    }
}