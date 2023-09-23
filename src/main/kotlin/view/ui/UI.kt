package view.ui


class UI: IUI {

    override fun displayWeatherNow(temp:String, humid:String, prec:String) {
        println("Current weather:")
        println("Temperature: $temp °C")
        println("Humidity: $humid %")
        println("Precipitation: $prec ml")
        println()
    }
}