package model.weatherReportHourly

class HourlyWeatherService {
    fun getWeatherLastHour(compositeData: List<String>): WeatherLastHourBuilder {
        return WeatherLastHourBuilder.Builder()
            .setTemperature(temp = compositeData[0])
            .setHumidity(humid = compositeData[1])
            .setPrecipitation(prec = compositeData[2])
            .build()
    }
}