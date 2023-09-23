package view.ui

class DayDecorator(private val ui: IUI): UIDecorator(ui) {
    override fun displayWeatherNow(temp:String, humid:String, prec:String) {
        val day = """
        \     (      /
   `.    \     )    /    .'
     `.   \   (    /   .'
       `.  .-''''-.  .'
 `~._    .'/_    _\`.    _.~'
     `~ /  / \  / \  \ ~'
_ _ _ _|  _\O/  \O/_  |_ _ _ _
       | (_)  /\  (_) |
    _.~ \  \      /  / ~._
 .~'     `. `.__.' .'     `~.
       .'  `-,,,,-'  `.
     .'   /    )   \   `.
   .'    /    (     \    `.
        /      )     \     
   
        """
        println(day)
        super.displayWeatherNow(temp, humid, prec)
    }
}