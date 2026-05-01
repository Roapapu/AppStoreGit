package com.example.fakestoreapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fakestoreapp.components.ProductItem
import com.example.fakestoreapp.models.productList
import com.example.fakestoreapp.ui.theme.Black
import com.example.fakestoreapp.ui.theme.White

@Composable
fun ProductsScreen(
    innerPadding: PaddingValues,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(innerPadding)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Fine Watches",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold,
                color = Black,
                letterSpacing = 2.sp
            )
        )
        Text(
            text = "Timeless elegance for your wrist",
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Black.copy(alpha = 0.6f)
            )
        )
        Spacer(modifier = Modifier.height(24.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(productList) { product ->
                ProductItem(
                    product = product,
                    onClick = {
                        navController.navigate("products/${product.id}")
                    }
                )
            }
        }
    }
}
