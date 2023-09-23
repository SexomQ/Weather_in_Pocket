package model.weatherRequest

import io.ktor.client.*
import io.ktor.client.request.*

class Api1Caller: IApi1Caller {
    override suspend fun apiCall(): String {
        val client = HttpClient()
        val data = client.get<String>("https://api.open-meteo.com/v1/forecast?latitude=47.0251&longitude=28.7975&hourly=temperature_2m,relativehumidity_2m,precipitation&timezone=Europe%2FBerlin&models=best_match")

        return data
    }
}