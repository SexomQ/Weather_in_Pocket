package AppLogic

import ui.IUI
import weatherReport.IWeatherService
import weatherReport.WeatherPlot

class AppLogic(private val ui:IUI, private val report: IWeatherService) {
    suspend fun collectData() {
        var firstChoice = 1
        while (firstChoice != 0) {
            firstChoice = ui.initial_menu()
            println(firstChoice)

            if (firstChoice == 1){
                val weatherData = report.getData()
                val plot = WeatherPlot()
                plot.plot(weatherData)
            }

            println()
        }

        println("Waiting for you next time!")
    }
}
