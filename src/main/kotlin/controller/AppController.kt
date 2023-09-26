package controller

import model.AppModel
import model.userValidation.User
import view.AppView

class AppController(val model: AppModel, val view: AppView) {

    suspend fun control() {
        println("Welcome to the Weather In The Pocket App!")
        println("Best weather app in the world!")
        println("Prepare for the best weather experience in a terminal!")
        println()
        println()
        println("----------------------------")
        println("The app is loading...")
        println("----------------------------")
        model.initializeWeatherData()
        initial_choice()
    }

    suspend fun initial_choice() {
        val init_choice = view.initial_menu()

        if (init_choice == "1") {
            // implement login here later
            // --------------------------------
            print("Enter username: "); val username = readln()
            print("Enter password: "); val password = readln()

            val user = User(username, password)
            val isValid = model.userSignIn(user)
            if (isValid) {
                println("You are loged in!")
                main_choice()
            } else {
                println("Password is not correct!")
                initial_choice()
            }
        }
        else if (init_choice == "2") {
            print("Enter username: "); val username = readln()
            print("Enter password: "); val password = readln()

            val user = User(username, password)
            val isValid = model.userSignIn(user)
            if (isValid) {
                println("You created a new account!")
                main_choice()
            } else {
                println("Lenght of pass > 8 chars!")
                initial_choice()
            }
        }
        else if (init_choice == "0") {
            println("Waiting for you next time!")
        }
    }

    suspend fun main_choice() {
        val main_choice = view.main_menu()

        if (main_choice == "1") {
            // implement weather here later
            // --------------------------------
            weather_choice()
        } else if (main_choice == "2") {
            model.refreshWeatherData()
            weather_choice()
        }
        else if (main_choice == "3") {
            // implement location here later
            // --------------------------------
            TODO("implement location")
        }
        else if (main_choice == "0") {
            initial_choice()
        }
    }

    suspend fun weather_choice() {
        val weather_choice = view.weather_menu()

        if (weather_choice == "1") {
            // implement forecast here later
            // --------------------------------
            plot_choice()
        }
        else if (weather_choice == "2") {
            // implement weather now here later
            // --------------------------------
//            println(model.getWeatherReportLastHour())
            val values = model.getWeatherReportLastHour()
            view.showWeatherNow(humid = values.humid, prec = values.prec, temp = values.temp)
            weather_choice()
        }
        else if (weather_choice == "0") {
            main_choice()
        }
    }

    suspend fun plot_choice() {
        val plot_choice = view.plot_menu()

        if (plot_choice == 1) {
            // implement advanced plot here later
            // --------------------------------
            model.plotForecast()
            plot_choice()
        }
        else if (plot_choice == 2) {
            // implement simple plot here later
            // --------------------------------
            model.plotSimpleForecast()
            plot_choice()
        }
        else if (plot_choice == 0) {
            weather_choice()
        }
    }
}
