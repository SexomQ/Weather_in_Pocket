package model

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

class AppModel: IWeatherObserver {

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

//    fun requestWeatherData(): WeatherDataPrototype {
//        val request = WeatherDataPrototype(Api1Adapter(Api1Caller()), AnyFrame.empty())
//        return request.clone()
//    }

    override fun update(newDf: AnyFrame) {
        df = newDf
    }

}