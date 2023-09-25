# Laboratory Work 2

### Course: Structural Design Patterns
### Author: Tudor Sclifos

----

## Theory
&ensp; &ensp; Structural design patterns are a category of design patterns that focus on the composition of classes and objects to form larger structures and systems. They provide a way to organize objects and classes in a way that is both flexible and efficient, while allowing for the reuse and modification of existing code. Structural design patterns address common problems encountered in the composition of classes and objects, such as how to create new objects that inherit functionality from existing objects, how to create objects that share functionality without duplicating code, or how to define relationships between objects in a flexible and extensible way.

## Objectives:

&ensp; &ensp; __1. Study and understand the Structural Design Patterns.__

&ensp; &ensp; __2. As a continuation of the previous laboratory work, think about the functionalities that your system will need to provide to the user.__

&ensp; &ensp; __3. Implement some additional functionalities, or create a new project using structural design patterns.__


## Implementation description

&ensp; &ensp; The first thing I implemented is the Adapter Pattern. It is used to adapt the Api1Caller for WheatherDataPrototype.
```kotlin
class Api1Adapter(private val api1Caller: IApi1Caller): IApi1Adapter, IApiStrategy {
    ...

    override suspend fun getData(refresh:Boolean): String {
        if ((refresh) or (apiResponse == "")) {
            apiResponse = api1Caller.apiCall()
        }
        return apiResponse
    }

    ...
}
```

&ensp; &ensp; The second pattern is Composite Pattern. This makes adding new features much easier.
```kotlin
class CompositeWeatherElement(private val elements: List<IHourlyWeather>) : IHourlyWeather {
    override fun getLastData(df: AnyFrame): String {
        return elements.joinToString(", ") { it.getLastData(df) }
    }
}
```
&ensp; &ensp; The third pattern is Decorator. It is used to make more variations of the UI.
```kotlin
abstract class UIDecorator(private val ui: IUI): IUI {
    override fun displayWeatherNow(temp:String, humid:String, prec:String) {
        ui.displayWeatherNow(temp, humid, prec)
    }
}

class DayDecorator(private val ui: IUI): UIDecorator(ui) {
    override fun displayWeatherNow(temp:String, humid:String, prec:String) {
        val day = """
            ...
        """
        println(day)
        super.displayWeatherNow(temp, humid, prec)
    }
}

class NightDecorator(private val ui: IUI): UIDecorator(ui) {
    override fun displayWeatherNow(temp:String, humid:String, prec:String) {
        val night = """
            ...
        """
        println(night)
        super.displayWeatherNow(temp, humid, prec)
    }
}
```

&ensp; &ensp; The fourth pattern is Facade. It is used to make the code more readable and easier to use.
```kotlin
class Facade {
    val temp = HourlyWeatherFactory.createHourlyElement("temperature")
    val humid = HourlyWeatherFactory.createHourlyElement("humidity")
    val prec = HourlyWeatherFactory.createHourlyElement("precipitation")

    val composite = CompositeWeatherElement(listOf(temp, humid, prec))

    fun getCompositeData(data: AnyFrame): List<String> {
        return composite.getLastData(data).split(", ")
    }
}
```

## Conclusions / Screenshots / Results
In conclusion, I learned about the structural design patterns and how to use them. I also learned how to make the code more readable and easier to use.

## References
* https://github.com/sspatari/tmps-labs/tree/master
* https://refactoring.guru/design-patterns/structural-patterns
* https://www.baeldung.com/kotlin-adapter-pattern
* https://www.baeldung.com/kotlin-composite-pattern
* https://chat.bloombot.ai/