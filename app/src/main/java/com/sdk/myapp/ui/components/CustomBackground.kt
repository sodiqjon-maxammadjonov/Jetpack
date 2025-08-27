package com.sdk.myapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager

@Composable
fun CustomBackground(
    appBar: @Composable (() -> Unit)? = null,
    body: @Composable (() -> Unit)? = null,
    bottomNavigation: @Composable (() -> Unit)? = null
) {
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                focusManager.clearFocus()
            }
    ) {
        appBar?.invoke()
        Box(
            modifier = Modifier.weight(1f)
        ) {
            body?.invoke()
        }

        bottomNavigation?.invoke()
    }
}