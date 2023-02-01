package com.example.fkbook.ui.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.fkbook.common.constants.AppRoutes
import com.example.fkbook.ui.theme.Black
import com.example.fkbook.ui.theme.DeepPink

data class BottomNavItem(
    val name: String,
    val icon: String = ""
)

@Composable
fun BottomNav(
    currentTab: String,
    navController: NavHostController = rememberNavController(),
    onTabChange: (String) -> Unit
) {

    val backStackEntry by navController.currentBackStackEntryAsState()
    val bottomNavItems = listOf(
        BottomNavItem(
            name = AppRoutes.Home.name
        ),
        BottomNavItem(
            name = AppRoutes.Friend.name
        ),
        BottomNavItem(
            name = AppRoutes.Video.name
        ),
        BottomNavItem(
            name = AppRoutes.Personal.name
        ),
        BottomNavItem(
            name = AppRoutes.Notifies.name
        ),
        BottomNavItem(
            name = AppRoutes.Settings.name
        ),
    )

    BottomNavigation(
        backgroundColor = Color(0xFFFFFFFF),
        elevation = 1.dp
    ) {
        bottomNavItems.forEach { item ->
            val selected = item.name == currentTab

            BottomNavigationItem(
                selected = selected,
                selectedContentColor = DeepPink,
                onClick = { onTabChange(item.name) },
                label = { Text(item.name, fontSize = 9.sp) },
                icon = { Text("") },
                unselectedContentColor = Black
            )
        }
    }
}