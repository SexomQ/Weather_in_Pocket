package model.refreshManager

interface IRefreshManager {
    fun addObserver(observer: IWeatherObserver)
    fun removeObserver(observer: IWeatherObserver)
    suspend fun fetchData()
}