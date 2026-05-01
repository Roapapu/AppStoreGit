package com.example.fakestoreapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fakestoreapp.screens.CartScreen
import com.example.fakestoreapp.screens.ProductDetailScreen
import com.example.fakestoreapp.screens.ProductsScreen
import com.example.fakestoreapp.screens.ProfileScreen
import com.example.fakestoreapp.ui.theme.Black
import com.example.fakestoreapp.ui.theme.FakeStoreAppTheme
import com.example.fakestoreapp.ui.theme.GrayMedium
import com.example.fakestoreapp.ui.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FakeStoreAppTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                
                val items = listOf(
                    NavigationItem("Home", "products", Icons.Default.Home),
                    NavigationItem("Cart", "cart", Icons.Default.ShoppingCart),
                    NavigationItem("Profile", "profile", Icons.Default.Person)
                )

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        // Solo mostramos la barra en las pestañas principales
                        val showBottomBar = items.any { it.route == currentDestination?.route }
                        if (showBottomBar) {
                            NavigationBar(
                                containerColor = White,
                                tonalElevation = 0.dp
                            ) {
                                items.forEach { item ->
                                    val isSelected = currentDestination?.hierarchy?.any { it.route == item.route } == true
                                    NavigationBarItem(
                                        icon = { 
                                            Icon(
                                                item.icon, 
                                                contentDescription = item.title, 
                                                modifier = Modifier.size(24.dp)
                                            ) 
                                        },
                                        selected = isSelected,
                                        onClick = {
                                            navController.navigate(item.route) {
                                                popUpTo(navController.graph.findStartDestination().id) {
                                                    saveState = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        },
                                        colors = NavigationBarItemDefaults.colors(
                                            selectedIconColor = Black,
                                            unselectedIconColor = GrayMedium,
                                            indicatorColor = Color.Transparent
                                        )
                                    )
                                }
                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "products"
                    ) {
                        composable(route = "products") {
                            ProductsScreen(innerPadding, navController)
                        }
                        composable(route = "cart") {
                            CartScreen(innerPadding)
                        }
                        composable(route = "profile") {
                            ProfileScreen(innerPadding)
                        }
                        composable(
                            route = "products/{id}",
                            arguments = listOf(
                                navArgument("id") {
                                    type = NavType.IntType
                                    nullable = false
                                }
                            )
                        ) { backStack ->
                            val id = backStack.arguments?.getInt("id") ?: 0
                            ProductDetailScreen(
                                id = id,
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}

data class NavigationItem(val title: String, val route: String, val icon: androidx.compose.ui.graphics.vector.ImageVector)
