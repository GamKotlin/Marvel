package com.gam.marvel.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gam.marvel.ui.NavigationKeys.Arg.ITEM_ID
import com.gam.marvel.ui.screens.CharacterDetailsScreen
import com.gam.marvel.ui.viewmodels.CharacterDetailsViewmodel
import com.gam.marvel.ui.screens.CharactersScreen
import com.gam.marvel.ui.viewmodels.CharactersViewModel
import com.gam.marvel.ui.theme.MarvelTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarvelTheme {
                CharacterApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MarvelTheme {
        CharacterApp()
    }
}

@Composable
private fun CharacterApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = NavigationKeys.Route.LIST) {
        composable(route = NavigationKeys.Route.LIST) {
            CharacterDestination(navController)
        }
        composable(
            route = NavigationKeys.Route.DETAILS,
            arguments = listOf(navArgument(ITEM_ID) { type = NavType.StringType })
        ) {
            FoodCategoryDetailsDestination()
        }
    }
}

@Composable
private fun CharacterDestination(navController: NavHostController) {
    val viewModel: CharactersViewModel = hiltViewModel()
    CharactersScreen(
        state = viewModel.state,
        onNavigationRequested = { itemId ->
            navController.navigate("${NavigationKeys.Route.LIST}/${itemId}")
        })
}

@Composable
private fun FoodCategoryDetailsDestination() {
    val viewModel: CharacterDetailsViewmodel = hiltViewModel()
    CharacterDetailsScreen(viewModel.state)
}

object NavigationKeys {
    object Arg {
        const val ITEM_ID = "itemID"
    }

    object Route {
        const val LIST = "list"
        const val DETAILS = "$LIST/{$ITEM_ID}"
    }
}