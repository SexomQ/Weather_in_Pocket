package model.refreshManager

import model.weatherRequest.Api1Adapter
import model.weatherRequest.Api1Caller
import model.weatherRequest.WeatherDataPrototype
import org.jetbrains.kotlinx.dataframe.AnyFrame

class RefreshManager {
    private val observers = mutableListOf<IWeatherObserver>()
    var df: AnyFrame = AnyFrame.empty()
        set(value) {
            field = value
            notifyObservers()
        }

    fun addObserver(observer: IWeatherObserver) {
        observers.add(observer)
    }

    fun removeObserver(observer: IWeatherObserver) {
        observers.remove(observer)
    }

    private fun notifyObservers() {
        observers.forEach { it.update(df) }
    }

    suspend fun fetchData(){
        val request = WeatherDataPrototype(Api1Adapter(Api1Caller()), AnyFrame.empty())
        df = request.clone().transformData()
    }
}