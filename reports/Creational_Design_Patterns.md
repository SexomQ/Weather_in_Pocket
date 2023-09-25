# Laboratory Work 2

### Course: Creational Design Patterns
### Author: Tudor Sclifos

----

## Theory
&ensp; &ensp; Creational design patterns are a category of design patterns that focus on the process of object creation. They provide a way to create objects in a flexible and controlled manner, while decoupling the client code from the specifics of object creation. Creational design patterns address common problems encountered in object creation, such as how to create objects with different initialization parameters, how to create objects based on certain conditions, or how to ensure that only a single instance of an object is created. There are several creational design patterns that have their own strengths and weaknesses. Each of it is best suited for solving specific problems related to object creation. By using creational design patterns, developers can improve the flexibility, maintainability, and scalability of their code.

## Objectives:

&ensp; &ensp; __1. Study and understand the Creational Design Patterns.__

&ensp; &ensp; __2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.__

&ensp; &ensp; __3. Use some creational design patterns for object instantiation in a sample project.__


## Implementation description

&ensp; &ensp; The first thing I implemented is the Singleton Pattern. This pattern ensures that only one instance of a class is created and provides a global point of access to that instance. As an example is App class that is used to start the application and it is the only instance of the class.

```kotlin
object App {
    val model = AppModel()
    val view = AppView()
    val controller = AppController(model, view)
    suspend fun run() {
        controller.control()
    }
}
```

&ensp; &ensp; The second pattern is Builder Pattern. This pattern is used to create complex objects with constituent parts that must be created in the same order or using a specific algorithm. As an example is the "WeatherLastHourBuilder" that has a Builder class inside.

```kotlin
data class WeatherLastHourBuilder(var temp: String = "0.0", var humid: String = "0.0", var prec: String = "0.0"){

    class Builder {
        private val report = WeatherLastHourBuilder()

        fun setTemperature(temp:String) = apply { report.temp = temp }
        fun setHumidity(humid:String) = apply { report.humid = humid }
        fun setPrecipitation(prec: String) = apply { report.prec = prec }
        fun build() = report
    }
}
```
&ensp; &ensp; The third pattern is Factory Method Pattern. This pattern is used to create objects without exposing the creation logic to the client and refers to the newly created object through a common interface. As an example is the "HourlyWeatherFactory" where I replaced the calls to the constructor with calls to a special factory method.

```kotlin
object HourlyWeatherFactory {
    fun createHourlyElement(type: String): IHourlyWeather {
        return when (type) {
            "temperature" -> HourlyTemperature()
            "precipitation" -> HourlyPrecipitation()
            "humidity" -> HourlyHumidity()
            else -> throw IllegalArgumentException("Unknown type: $type")
        }
    }
}
```

&ensp; &ensp; The fourth pattern is Prototype. This pattern is used to create objects by cloning an existing object. As an example is the "WeatherDataPrototype" class that implements the Cloneable (IWeatherDataPrototype) interface.

```kotlin
interface IWeatherDataPrototype {
    fun clone(): IWeatherDataPrototype
}

data class WeatherDataPrototype (private var strategy: IApiStrategy, var dataframe:AnyFrame) : IWeatherDataPrototype{
    ...

    override fun clone(): WeatherDataPrototype {
        return copy()
    }
}
```

## Conclusions / Screenshots / Results
In conclusion, I learned about the Creational Design Patterns and how to use them in a project. I used the Singleton Pattern, Builder Pattern, Factory Method Pattern and Prototype Pattern. I learned how to use them and how to implement them in a project.

## References
* https://github.com/sspatari/tmps-labs/tree/master
* https://refactoring.guru/design-patterns/creational-patterns
* https://www.baeldung.com/creational-design-patterns
* https://www.geeksforgeeks.org/creational-design-patterns/
* https://chat.bloombot.ai/