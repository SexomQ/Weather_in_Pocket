package view.ui

abstract class UIDecorator(private val ui: IUI): IUI {
    override fun displayWeatherNow(temp:String, humid:String, prec:String) {
         ui.displayWeatherNow(temp, humid, prec)
    }
}