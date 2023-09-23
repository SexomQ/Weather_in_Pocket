import controller.AppController
import model.AppModel
import view.AppView

// This is a singleton pattern
object App {
    val model = AppModel()
    val view = AppView()
    val controller = AppController(model, view)
    suspend fun run() {
        controller.control()
    }
}