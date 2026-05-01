package com.example.fakestoreapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fakestoreapp.ui.theme.Black
import com.example.fakestoreapp.ui.theme.White

@Composable
fun ProfileScreen(innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(innerPadding)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "John Doe",
            style = MaterialTheme.typography.headlineSmall.copy(
                fontWeight = FontWeight.Bold,
                color = Black
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Premium Member since 2023",
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Black.copy(alpha = 0.5f)
            )
        )
    }
}
