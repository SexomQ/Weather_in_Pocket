# Laboratory Work 1

### Course: SOLID Principles
### Author: Tudor Sclifos

----

## Theory
&ensp; &ensp; SOLID is a set of five object-oriented design principles intended to make software designs more maintainable, flexible, and easy to understand. The acronym stands for Single Responsibility Principle, Open-Closed Principle, Liskov Substitution Principle, Interface Segregation Principle, and Dependency Inversion Principle. Each principle addresses a specific aspect of software design, such as the organization of responsibilities, the handling of dependencies, and the design of interfaces. By following these principles, software developers can create more modular, testable, and reusable code that is easier to modify and extend over time. These principles are widely accepted and adopted in the software development community and can be applied to any object-oriented programming language.

## Objectives:

&ensp; &ensp; __1. Study and understand the SOLID Principles.__

&ensp; &ensp; __2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.__

&ensp; &ensp; __3. Create a sample project that respects SOLID Principles.__


## Implementation description

&ensp; &ensp; The first thing I implemented is the Single Responsibility Principle. This principle states that a class should have only one reason to change. As an example is the class "UI" which is responsible for the presenting the data to the user.

```kotlin
class UI: IUI {

    override fun displayWeatherNow(temp:String, humid:String, prec:String) {
        println("Current weather:")
        println("Temperature: $temp °C")
        println("Humidity: $humid %")
        println("Precipitation: $prec ml")
        println()
    }
}
```

&ensp; &ensp; The second principle is the Open-Closed Principle. This principle states that software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification. As an example is the "weatherRequest" package that can be extended with new API's but the existing code will not be modified. This is done by using WeatherDataPrototype that manages the API user wants to use.

```kotlin
data class WeatherDataPrototype (private var strategy: IApiStrategy, var dataframe:AnyFrame) : IWeatherDataPrototype{
    fun setStrategy(strategy: IApiStrategy) {
        this.strategy = strategy
    }

    suspend fun transformData(): AnyFrame {
        this.dataframe = strategy.transformData()
        return dataframe
    }

    override fun clone(): WeatherDataPrototype {
        return copy()
    }
}
```
&ensp; &ensp; The third principle is the Liskov Substitution Principle. This principle states that objects in a program should be replaceable with instances of their subtypes without altering the correctness of that program. As an example is the WeatherPlot and WeatherPlotSimple that implements the IWeatherPlot interface. This allows to use the same methods for both classes, therefore the classes are interchangeable.

```kotlin
interface IWeatherPlot {
    fun plot(dataFrame: AnyFrame)
}

class WeatherPlot: IPlotHumidity, IPlotTemperature, IPlotPrecipitation, IWeatherPlot {
    ...

    override fun plot(dataFrame: AnyFrame) {
        plotTemperature(dataFrame)
        plotHumidity(dataFrame)
        plotPrecipitation(dataFrame)
    }
}

class WeatherPlotSimple: IPlotTemperature, IWeatherPlot {
    ...

    override fun plot(dataFrame: AnyFrame) {
        plotTemperature(dataFrame)
    }
}
```

&ensp; &ensp; The fourth principle is the Interface Segregation Principle. This principle states that many client-specific interfaces are better than one general-purpose interface. As an example is the IPlotTemperature, IPlotHumidity, IPlotPrecipitation interfaces that are used by the WeatherPlot class. This allows to use only the methods that are needed for the class.

```kotlin
interface IPlotHumidity {
    fun plotHumidity(dataFrame: AnyFrame)
}

interface IPlotPrecipitation {
    fun plotPrecipitation(dataFrame: AnyFrame)
}

interface IPlotTemperature {
    fun plotTemperature(dataFrame: AnyFrame)
}

class WeatherPlot: IPlotHumidity, IPlotTemperature, IPlotPrecipitation, IWeatherPlot {
    ...
}

class WeatherPlotSimple: IPlotTemperature, IWeatherPlot {
    ...
}
```

&ensp; &ensp; The fifth principle is the Dependency Inversion Principle. This principle states that one should depend upon abstractions, not concretions. As an example is the dependency between the Api1Adapter calss and Api1Caller class. Api1Adapter depends on the abstraction ApiCaller and not on the concretion Api1Caller.

```kotlin
interface IApi1Caller {
    suspend fun apiCall(): String
}

class Api1Adapter(private val api1Caller: IApi1Caller): IApi1Adapter, IApiStrategy {...}
```

## Conclusions / Screenshots / Results
In conclusion, SOLID principles are a set of rules that help to create a better code. These principles are widely accepted and adopted in the software development community and can be applied to any object-oriented programming language and I managed to apply them in my project.


## References
* https://github.com/sspatari/tmps-labs/tree/master
* https://en.wikipedia.org/wiki/SOLID
* https://www.baeldung.com/solid-principles
* https://www.geeksforgeeks.org/solid-principle-in-programming-understand-with-real-life-examples/
* https://chat.bloombot.ai/