package com.example.fakestoreapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Watch
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fakestoreapp.models.productList
import com.example.fakestoreapp.ui.theme.Black
import com.example.fakestoreapp.ui.theme.GrayLight
import com.example.fakestoreapp.ui.theme.White

@Composable
fun ProductDetailScreen(id: Int, navController: NavController) {
    val product = productList.find { it.id == id }

    if (product == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Product not found")
        }
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .background(GrayLight)
        ) {
            Icon(
                imageVector = Icons.Default.Watch,
                contentDescription = product.title,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                tint = Black
            )
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.TopStart)
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Black)
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Text(
                text = product.category.uppercase(),
                style = MaterialTheme.typography.labelLarge.copy(
                    color = Black.copy(alpha = 0.5f),
                    letterSpacing = 2.sp
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = product.title,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = Black
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "$${product.price}",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Medium,
                    color = Black
                )
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = product.description,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Black.copy(alpha = 0.7f),
                    lineHeight = 24.sp
                )
            )
            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = { /* Add to cart */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Black)
            ) {
                Text(
                    "Add to Cart",
                    style = MaterialTheme.typography.titleMedium.copy(color = White)
                )
            }
        }
    }
}
