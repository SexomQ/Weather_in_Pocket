package ui
import java.util.Scanner


class UI:IUI {

    override fun initial_menu():Int {
        println("Choose what you want to see (number):")
        println("1. Show the weather for Chisinau")
        println("2. Refresh and show")
        println("3. Change location")
        println()
        println("0. Exit")

        val choice = Scanner(System.`in`).nextInt()

        return choice
    }
}