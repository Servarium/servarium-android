package it.android.servarium

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.surf.retrofitlesson.presentation.navigation.AppNavigationGraph
import dev.surf.retrofitlesson.presentation.navigation.Route

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val isAuthorized = false
            val startDestination = if (isAuthorized) Route.MainScreen().route else Route.Login.route
            AppNavigationGraph(startDestination = startDestination)
        }
    }
}

