package com.sdk.myapp.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResponsiveExample() {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    val responsivePadding = when {
        screenWidth < 600.dp -> 16.dp
        screenWidth < 840.dp -> 24.dp
        else -> 32.dp
    }

    val responsiveTextSize = when {
        screenWidth < 600.dp -> 16.sp
        screenWidth < 840.dp -> 18.sp
        else -> 20.sp
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(responsivePadding)
    ) {
        Text(
            text = "Responsive Matn",
            fontSize = responsiveTextSize,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}