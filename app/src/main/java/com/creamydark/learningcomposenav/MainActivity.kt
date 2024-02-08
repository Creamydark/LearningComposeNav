package com.creamydark.learningcomposenav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.rememberNavController
import com.creamydark.learningcomposenav.model.BottomBarDestination
import com.creamydark.learningcomposenav.screens.NavGraphs
import com.creamydark.learningcomposenav.screens.appCurrentDestinationAsState
import com.creamydark.learningcomposenav.screens.destinations.Destination
import com.creamydark.learningcomposenav.screens.destinations.TypedDestination
import com.creamydark.learningcomposenav.screens.startAppDestination
import com.creamydark.learningcomposenav.ui.theme.LearningComposeNavTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.navigation.popUpTo
import com.ramcosta.composedestinations.utils.startDestination

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningComposeNavTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = {
                            BottomBar(navController)
                        }
                    ) {
                        _->
                        DestinationsNavHost(navGraph = NavGraphs.root, navController = navController)
                    }
                }
            }
        }
    }
}


@Composable
fun BottomBar(
    navController: NavController,
) {
    val currentDestination: Destination = navController.appCurrentDestinationAsState().value ?: NavGraphs.root.startAppDestination
//    val currentDestination: TypedDestination<out Any?> = navController.appCurrentDestinationAsState().value ?: NavGraphs.root.startAppDestination
    NavigationBar {
        BottomBarDestination.entries.forEach { destination ->
            NavigationBarItem(
                selected = currentDestination == destination.direction,
                onClick = {
                    navController.navigate(
                        destination.direction,
                        fun NavOptionsBuilder.() {
                            popUpTo(NavGraphs.root) {
                                saveState = true
//                                inclusive = true
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        },
                    )
                },
                icon = { Icon(destination.icon, contentDescription = "")},
                label = { Text(text = destination.label) },
            )
        }
    }
}

