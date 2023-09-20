package weatherReport

data class WeatherReport(var temp: Float = 0f, var humid: Float = 0f, var prec: Float = 0f){

    class Builder {
        private val report = WeatherReport()

        fun setTemperature(temp:Float) = apply { report.temp = temp }
        fun setHumidity(humid:Float) = apply { report.humid = humid }
        fun setPrecipitation(prec: Float) = apply { report.prec = prec }
        fun build() = report
    }
}