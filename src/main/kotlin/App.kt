import controller.AppController
import model.AppModel
import model.refreshManager.RefreshManager
import view.AppView

// This is a singleton pattern
object App {
    val model = AppModel(RefreshManager())
    val view = AppView()
    val controller = AppController(model, view)
    suspend fun run() {
        controller.control()
    }
}