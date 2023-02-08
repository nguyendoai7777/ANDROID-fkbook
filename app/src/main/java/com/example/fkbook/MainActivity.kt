package com.example.fkbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.fkbook.common.constants.AppRoutes
import com.example.fkbook.ui.components.BottomNav
import com.example.fkbook.ui.screens.friends.Friend
import com.example.fkbook.ui.screens.game.GameCenter
import com.example.fkbook.ui.screens.home.HomeScreen
import com.example.fkbook.ui.theme.FkbookTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FkbookTheme {
                // A surface container using the 'background' color from the theme
                AppMain()
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AppMain(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = AppRoutes.valueOf(
        backStackEntry?.destination?.route ?: AppRoutes.Home.name
    )
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    DisposableEffect(systemUiController, useDarkIcons) {
        // Update all of the system bar colors to be transparent, and use
        // dark icons if we're in light theme
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons
        )

        // setStatusBarColor() and setNavigationBarColor() also exist

        onDispose {}
    }
    Scaffold(
        bottomBar = {
            BottomNav(
                currentScreen.name
            ) {
                navController.navigate(it)
            }
        }

    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppRoutes.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(AppRoutes.Home.name) {
                HomeScreen()
            }
            composable(AppRoutes.Video.name) {
                GameCenter()
            }
            composable(AppRoutes.Friend.name) {
                Friend()
            }
            composable(AppRoutes.Notifies.name) {
                Text(text = stringResource(id = R.string.notification))
            }
            composable(AppRoutes.Personal.name) {
                Text(text = stringResource(id = R.string.personal))
            }
            composable(AppRoutes.Settings.name) {
                Text(text = stringResource(id = R.string.settings))
            }
        }
    }
}