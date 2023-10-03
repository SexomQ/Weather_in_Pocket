package model.weatherReportHourly

import org.jetbrains.kotlinx.dataframe.AnyFrame

class CompositeFacade(val hourlyFactory: IHourlyWeatherFactory, val compositeWeather: IHourlyWeather, val temp: IHourlyWeather, val humid: IHourlyWeather, val prec: IHourlyWeather) : ICompositeFacade {
    override fun getCompositeData(data: AnyFrame): List<String> {
        return compositeWeather.getLastData(data).split(", ")
    }
}