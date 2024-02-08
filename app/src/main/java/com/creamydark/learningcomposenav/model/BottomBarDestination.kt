package com.creamydark.learningcomposenav.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.creamydark.learningcomposenav.screens.destinations.HomeDestinationDestination
import com.creamydark.learningcomposenav.screens.destinations.ProfileDestinationDestination
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec

enum class BottomBarDestination(
    val direction: DirectionDestinationSpec,
    val icon: ImageVector,
    val label: String,
) {
    Home(
        direction = HomeDestinationDestination,
        icon = Icons.Outlined.Home,
        label = "Home"
    ),
    Profile(
        direction = ProfileDestinationDestination,
        icon = Icons.Outlined.Person,
        label = "Profile"
    )
}