# Laboratory Work 2

### Course: Behavioral Design Patterns
### Author: Tudor Sclifos

----

## Theory
&ensp; &ensp; Behavioral design patterns are a category of design patterns that focus on the interaction and communication between objects and classes. They provide a way to organize the behavior of objects in a way that is both flexible and reusable, while separating the responsibilities of objects from the specific implementation details. Behavioral design patterns address common problems encountered in object behavior, such as how to define interactions between objects, how to control the flow of messages between objects, or how to define algorithms and policies that can be reused across different objects and classes.

## Objectives:

&ensp; &ensp; __1. Study and understand the Behavioral Design Patterns.__

&ensp; &ensp; __2. As a continuation of the previous laboratory work, think about what communication between software entities might be involed in your system.__

&ensp; &ensp; __3. Create a new Project or add some additional functionalities using behavioral design patterns.__

## Implementation description

&ensp; &ensp; The first thing I implemented is the Chain of Responsibility Pattern. It is used to validate the user credentials in a chain.
```kotlin
class ValidationChain {
    private val validators = mutableListOf<IValidator<User>>()

    fun addValidator(validator: IValidator<User>): ValidationChain {
        validators.add(validator)
        return this
    }

    fun validate(user: User): Boolean {
        return validators.all { it.validate(user) }
    }
}
```

&ensp; &ensp; The second pattern is Mediator called AppController. It is used to make the interation between View and Model.
```kotlin
class AppController(val model: AppModel, val view: AppView) {
    var refresher = RefreshManager()

    suspend fun control() {
        refresher.addObserver(model)
        refresher.fetchData()
        initial_choice()
    }
    
    ...
}
```
&ensp; &ensp; The third pattern is Observer. It is used to notify the Model when the data is changed.
```kotlin
class RefreshManager {
    private val observers = mutableListOf<IWeatherObserver>()
    var df: AnyFrame = AnyFrame.empty()
        set(value) {
            field = value
            notifyObservers()
        }

    ...
    private fun notifyObservers() {
        observers.forEach { it.update(df) }
    }

    suspend fun fetchData(){
        val request = WeatherDataPrototype(Api1Adapter(Api1Caller()), AnyFrame.empty())
        df = request.clone().transformData()
    }
}
```

&ensp; &ensp; The fourth pattern is Strategy. It is used to manage the choice of the API provider.
```kotlin
interface IApiStrategy {
    suspend fun transformData(): AnyFrame
}

data class WeatherDataPrototype (private var strategy: IApiStrategy, var dataframe:AnyFrame) : IWeatherDataPrototype{
    fun setStrategy(strategy: IApiStrategy) {
        this.strategy = strategy
    }

    suspend fun transformData(): AnyFrame {
        this.dataframe = strategy.transformData()
        return dataframe
    }
    ...
}
```

## Conclusions / Screenshots / Results
In conclusion, I learned about the Behavioral Design Patterns and how to use them in Kotlin. I also learned how to use the Observer pattern to notify the Model when the data is changed. I learned how to use the Strategy pattern to manage the choice of the API provider. I learned how to use the Mediator pattern to make the interation between View and Model. I learned how to use the Chain of Responsibility pattern to validate the user credentials in a chain.

## References
* https://github.com/sspatari/tmps-labs/tree/master
* https://refactoring.guru/design-patterns/behavioral-patterns
* https://www.baeldung.com/kotlin-behavioral-design-patterns
* https://www.tutorialspoint.com/design_pattern/chain_of_responsibility_pattern.htm
* https://chat.bloombot.ai/