package com.example.home.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainContent(modifier: Modifier = Modifier) {
    Text(text = "Hello Jeff", modifier)
}