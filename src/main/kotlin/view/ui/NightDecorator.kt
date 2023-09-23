package view.ui

class NightDecorator(private val ui: IUI): UIDecorator(ui) {
    override fun displayWeatherNow(temp:String, humid:String, prec:String) {
        val night = """
         ___---___                    
      .--         --.      
    ./   ()      .-. \.
   /   o    .   (   )  \
  / .            '-'    \         
 | ()    .  O         .  |      
|                         |      
|    o           ()       |
|       .--.          O   |            
 | .   |    |            |
  \    `.__.'    o   .  /    
   \                   /                   
    `\  o    ()      /'         
      `--___   ___--'
            ---
        """
        println(night)
        super.displayWeatherNow(temp, humid, prec)
    }
}