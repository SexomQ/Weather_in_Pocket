import AppLogic.AppLogic
import ui.UI
import weatherReport.WeatherProvider
import weatherReport.WeatherService

class App {
    suspend fun run(){
        AppLogic(UI(), WeatherService(WeatherProvider())).collectData()
    }
}