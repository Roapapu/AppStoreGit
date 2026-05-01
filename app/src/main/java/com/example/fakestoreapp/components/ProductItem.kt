package com.example.fakestoreapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fakestoreapp.models.Product
import com.example.fakestoreapp.ui.theme.Black
import com.example.fakestoreapp.ui.theme.GrayLight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Watch

@Composable
fun ProductItem(
    product: Product,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = GrayLight),
            elevation = CardDefaults.cardElevation(0.dp)
        ) {
            androidx.compose.material3.Icon(
                imageVector = Icons.Default.Watch,
                contentDescription = product.title,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                tint = Black
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = product.title,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Medium,
                color = Black,
                fontSize = 14.sp
            ),
            maxLines = 1
        )
        Text(
            text = "$${product.price}",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold,
                color = Black,
                fontSize = 16.sp
            )
        )
    }
}
