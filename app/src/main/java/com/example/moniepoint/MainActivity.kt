package com.example.moniepoint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calculate.ui.CalculateScreen
import com.example.calculate.ui.CompleteScreen
import com.example.home.ui.HomeScreen
import com.example.moniepoint.ui.theme.MoniepointTheme
import com.example.home.model.Screen
import com.example.shipment.ui.ShipmentScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoniepointTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    AppScreen(navController)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppScreen(navController: NavHostController) {
    var showSearchResultsOnly by remember { mutableStateOf(false) }

    NavHost(navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { HomeScreen (showSearchResultsOnly, {
            if (it.isNotEmpty()) { navController.navigate(it) }
            }, {
                    showSearchResultsOnly = it
             })
        }

        composable(Screen.Calculate.route) {
            CalculateScreen( { navController.navigate(Screen.Complete.route) }, { navController.popBackStack() })
        }

        composable(Screen.Shipment.route) { ShipmentScreen {
            navController.popBackStack()
        } }
        composable(Screen.Complete.route) { CompleteScreen {
            navController.navigate(Screen.Home.route)
        } }
    }
}
