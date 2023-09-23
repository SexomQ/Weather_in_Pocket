package view

import view.ui.DayDecorator
import view.ui.NightDecorator
import view.ui.UI
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.*

class AppView {
    fun initial_menu():String {
        while (true) {
            println("Please LogIn:")
            println("1. Sign In")
            println("2. Sign Up")
            println()
            println("0. Close app")
            println()

            val choice = input()

            when (choice) {
                "1" -> return "1"
                "2" -> return "2"
                "0" -> return "0"
                else -> println("Wrong input, try again")
            }
        }
    }

    fun login_menu():List<String> {
        print("Login:"); val login = input()
        println()
        print("Password:"); val password = input()

        return listOf(login, password)
    }

    fun main_menu():String {
        while (true) {
            println("Choose what you want to see (number):")
            println("1. Show the weather for Chisinau")
            println("2. Refresh and show")
            println("3. Choose another location")
            println()
            println("0. LogOut")

            val choice = input()

            when (choice) {
                "1" -> return "1"
                "2" -> return "2"
                "3" -> return "3"
                "0" -> return "0"
                else -> println("Wrong input, try again")
            }
        }
    }

    fun weather_menu():String {
        while (true) {
            println("Choose what you want to see (number):")
            println("1. Check the forecast for 5 days")
            println("2. Show the weather now")
            println()
            println("0. Back")

            val choice = input()

            when (choice) {
                "1" -> return "1"
                "2" -> return "2"
                "0" -> return "0"
                else -> println("Wrong input, try again")
            }
        }
    }

    fun plot_menu():Int {
        while (true) {
            println("Choose what you want to see (number):")
            println("1. Advanced plot")
            println("2. Simple plot")
            println()
            println("0. Back")

            val choice = input()

            when (choice) {
                "1" -> return 1
                "2" -> return 2
                "0" -> return 0
                else -> println("Wrong input, try again")
            }
        }
    }

    private fun input():String {
        return Scanner(System.`in`).nextLine()
    }

    fun showWeatherNow(temp:String, humid:String, prec:String) {
        val defaultUI = UI()
        val nightUI = NightDecorator(defaultUI)
        val dayUI = DayDecorator(defaultUI)

        val current = LocalDateTime.now()
        val startOfDay = LocalTime.of(6, 0) // 6:00 AM
        val endOfDay = LocalTime.of(20, 0) // 8:00 PM
        if ((LocalTime.now().isAfter(startOfDay)) && (LocalTime.now().isBefore(endOfDay))) {
            dayUI.displayWeatherNow(temp, humid, prec)
        } else {
            nightUI.displayWeatherNow(temp, humid, prec)
        }

    }
}