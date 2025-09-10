package com.sam.designpatterns.memory_leak

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemoryLeakScreen(
    memoryLeakViewModel: MemoryLeakViewModel
) {
    val resourceString by memoryLeakViewModel.resourceString.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Memory Leak Screen") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {}) {
                Text(text = "Trigger Memory Leak")
            }
            resourceString?.let{
                Text(text = it)
            }
        }
    }
}
