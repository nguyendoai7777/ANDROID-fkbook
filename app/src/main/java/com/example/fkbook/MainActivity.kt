package com.example.fkbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.fkbook.common.constants.AppRoutes
import com.example.fkbook.ui.components.BottomNav
import com.example.fkbook.ui.screens.home.HomeScreen
import com.example.fkbook.ui.theme.FkbookTheme

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

@Composable
fun AppMain(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = AppRoutes.valueOf(
        backStackEntry?.destination?.route ?: AppRoutes.Home.name
    )
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
                Text(text = stringResource(id = R.string.video))
            }
            composable(AppRoutes.Friend.name) {
                Text(text = stringResource(id = R.string.friend))
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