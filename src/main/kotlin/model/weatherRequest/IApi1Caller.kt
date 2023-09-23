package model.weatherRequest

interface IApi1Caller {
    suspend fun apiCall(): String
}