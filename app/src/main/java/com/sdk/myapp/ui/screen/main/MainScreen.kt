package com.sdk.myapp.ui.screen.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import com.sdk.myapp.ui.components.CustomAppBar
import com.sdk.myapp.ui.components.CustomBackground
import com.sdk.myapp.ui.screen.main.components.BottomNavigation
import com.sdk.myapp.ui.screen.main.components.BottomNavItem

// Har bir ekran uchun ma'lumotlarni saqlash uchun data class
data class ScreenInfo(
    val title: String,
    val subtitle: String,
    val content: @Composable () -> Unit
)

@Composable
fun MainScreen() {
    var selectedTab by remember { mutableIntStateOf(0) }

    val screens = listOf(
        ScreenInfo(
            title = "Bosh Sahifa",
            subtitle = "Xush kelibsiz",
            content = { HomeContent() }
        ),
        ScreenInfo(
            title = "Qidiruv",
            subtitle = "Qidirishni boshlang",
            content = { SearchContent() }
        ),
        ScreenInfo(
            title = "Sevimlilar",
            subtitle = "Sizning sevimlilar ro'yxatingiz",
            content = { FavoritesContent() }
        ),
        ScreenInfo(
            title = "Profil",
            subtitle = "Shaxsiy ma'lumotlaringiz",
            content = { ProfileContent() }
        )
    )

    // Joriy ekran ma'lumotlari
    val currentScreen = screens[selectedTab]

    CustomBackground(
        appBar = {
            CustomAppBar(
                title = currentScreen.title,
                subtitle = currentScreen.subtitle,
                // Agar kerak bo'lsa, leadingIcon va actions qo'shishingiz mumkin
                // leadingIcon = { /* Icon qo'shish */ },
                // actions = { /* Action buttonlar */ }
            )
        },
        body = {
            currentScreen.content()
        },
        bottomNavigation = {
            val items = listOf(
                BottomNavItem(title = "Bosh", icon = Icons.Default.Home),
                BottomNavItem(title = "Qidiruv", icon =  Icons.Default.Search),
                BottomNavItem(title = "Sevimlilar", icon = Icons.Default.Favorite),
                BottomNavItem(title = "Profil", icon = Icons.Default.Person)
            )

            BottomNavigation(
                items = items,
                selectedIndex = selectedTab,
                onItemClick = { selectedTab = it }
            )
        }
    )
}

// Content composable'lar
@Composable
fun HomeContent() {
    Text("Bosh sahifa content", modifier = Modifier.padding(16.dp))
}

@Composable
fun SearchContent() {
    Text("Qidiruv content", modifier = Modifier.padding(16.dp))
}

@Composable
fun FavoritesContent() {
    Text("Sevimlilar content", modifier = Modifier.padding(16.dp))
}

@Composable
fun ProfileContent() {
    Text("Profil content", modifier = Modifier.padding(16.dp))
}