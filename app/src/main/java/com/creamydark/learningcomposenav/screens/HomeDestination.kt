package com.creamydark.learningcomposenav.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import com.creamydark.learningcomposenav.screens.destinations.HomeDestinationDestination
import com.creamydark.learningcomposenav.screens.destinations.MimingScreenDestinationDestination
import com.creamydark.learningcomposenav.screens.destinations.ProfileDestinationDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.popUpTo

@RootNavGraph(start = true)
@Destination
@Composable
fun HomeDestination(
    navigator: DestinationsNavigator
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        var name by remember {
            mutableStateOf("")
        }
        Text(text = "Home")
        TextField(modifier = Modifier.fillMaxWidth(), value = name, onValueChange = {name = it})
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                navigator.navigate(
                    MimingScreenDestinationDestination(
                        name = name,
                    ),
                ){

//                    popUpTo(NavGraphs.root) {
//                        saveState = true
//                        inclusive = true
//                    }

                    // Avoid multiple copies of the same destination when
                    // reselecting the same item
                    launchSingleTop = true
                    // Restore state when reselecting a previously selected item
//                    restoreState = true
                }
            }
        ) {
            Text(text = "Go to Profile")
        }
    }
}


