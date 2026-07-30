package android.ai.hilt_integration_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.MenuBook
import androidx.compose.material.icons.rounded.QuestionAnswer
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import android.ai.hilt_integration_app.ui.theme.HiltIntegrationAppTheme
import android.ai.hilt_integration_app.ui.Route
import android.ai.hilt_integration_app.ui.catalog.CatalogScreen
import android.ai.hilt_integration_app.ui.product.ProductScreen
import android.ai.hilt_integration_app.ui.interview.InterviewHubScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HiltIntegrationAppTheme {
                MainApp()
            }
        }
    }
}

@Composable
fun MainApp() {
    var currentRoute by remember { mutableStateOf<Route>(Route.Catalog) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = currentRoute == Route.Catalog,
                    onClick = { currentRoute = Route.Catalog },
                    icon = { Icon(Icons.AutoMirrored.Rounded.MenuBook, "Catalog") },
                    label = { Text("Catalog") }
                )
                NavigationBarItem(
                    selected = currentRoute == Route.Products,
                    onClick = { currentRoute = Route.Products },
                    icon = { Icon(Icons.Rounded.ShoppingCart, "Products") },
                    label = { Text("Products") }
                )
                NavigationBarItem(
                    selected = currentRoute == Route.Interview,
                    onClick = { currentRoute = Route.Interview },
                    icon = { Icon(Icons.Rounded.QuestionAnswer, "Interview") },
                    label = { Text("Interview") }
                )
            }
        }
    ) { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
            when (currentRoute) {
                Route.Catalog -> CatalogScreen()
                Route.Products -> ProductScreen()
                Route.Interview -> InterviewHubScreen()
                else -> {}
            }
        }
    }
}