package model.weatherReportHourly

data class WeatherLastHourBuilder(var temp: String = "0.0", var humid: String = "0.0", var prec: String = "0.0"){

    class Builder {
        private val report = WeatherLastHourBuilder()

        fun setTemperature(temp:String) = apply { report.temp = temp }
        fun setHumidity(humid:String) = apply { report.humid = humid }
        fun setPrecipitation(prec: String) = apply { report.prec = prec }
        fun build() = report
    }


}