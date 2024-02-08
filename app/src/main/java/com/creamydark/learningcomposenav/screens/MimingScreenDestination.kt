package com.creamydark.learningcomposenav.screens

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.creamydark.learningcomposenav.screens.destinations.ProfileDestinationDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.popUpTo

@Destination
@Composable
fun MimingScreenDestination(
    name:String,
    navigator: DestinationsNavigator
) {
    Text(text = name, modifier = Modifier.clickable {
        navigator.navigate(ProfileDestinationDestination){
            popUpTo(
                NavGraphs.root
            ){

            }
            launchSingleTop = true
        }
    })
}