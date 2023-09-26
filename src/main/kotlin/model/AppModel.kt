package model

import model.refreshManager.IRefreshManager
import model.refreshManager.IWeatherObserver
import model.userValidation.LoginValidator
import model.userValidation.PasswordValidator
import model.userValidation.User
import model.userValidation.ValidationChain
import model.weatherReportForecast.WeatherPlot
import model.weatherReportForecast.WeatherPlotSimple
import model.weatherReportHourly.HourlyWeatherService
import model.weatherReportHourly.WeatherLastHourBuilder
import org.jetbrains.kotlinx.dataframe.AnyFrame

class AppModel(val refresher : IRefreshManager): IWeatherObserver {

    var df = AnyFrame.empty()

    fun getWeatherReportLastHour(): WeatherLastHourBuilder {
        return HourlyWeatherService().getWeatherLastHour(df)
    }

    fun plotForecast() {
        val plot = WeatherPlot().plot(df)
    }

    fun plotSimpleForecast() {
        val plot = WeatherPlotSimple().plot(df)
    }

    fun userSignIn(user: User): Boolean {
        val validationChain = ValidationChain()
            .addValidator(LoginValidator())
            .addValidator(PasswordValidator())

        val isValid = validationChain.validate(user)

        return isValid
    }

    suspend fun initializeWeatherData() {
        refresher.addObserver(this)
        refresher.fetchData()
    }

    suspend fun refreshWeatherData() {
        refresher.fetchData()
    }

    override fun update(newDf: AnyFrame) {
        df = newDf
    }

}