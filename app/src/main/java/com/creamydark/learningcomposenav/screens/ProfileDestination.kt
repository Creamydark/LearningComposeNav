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
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun ProfileDestination() {
    var text by remember {
        mutableStateOf("Profile")
    }
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = text)
        TextField(
            modifier = Modifier.fillMaxWidth(), value = text,
            onValueChange = {
                text = it
            },
        )
        Button(onClick = {
                    text = "clickedddddd"
        },Modifier.fillMaxWidth()) {
            Text(text = "Placeeee")

        }
    }
}