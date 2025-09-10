package com.sam.designpatterns

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModelProvider
import com.sam.designpatterns.memory_leak.MemoryLeakScreen
import com.sam.designpatterns.memory_leak.MemoryLeakViewModel
import com.sam.designpatterns.memory_leak.MemoryLeakViewModelFactory
import com.sam.designpatterns.ui.theme.DesignPatternsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var memoryLeakViewModel: MemoryLeakViewModel
    private lateinit var myObserver: LifecycleObserver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //memoryLeakViewModel = ViewModelProvider(this).get(MemoryLeakViewModel::class)

        memoryLeakViewModel = ViewModelProvider(
            this,
            MemoryLeakViewModelFactory(application)
        ).get(MemoryLeakViewModel::class.java)
        setContent {
            DesignPatternsTheme {
                MemoryLeakScreen(
                    memoryLeakViewModel = memoryLeakViewModel
                )
            }
        }
        myObserver = object : LifecycleObserver{}
        lifecycle.addObserver(myObserver)
    }
    override fun onDestroy(){
        lifecycle.removeObserver(myObserver)
        super.onDestroy()
    }
}

