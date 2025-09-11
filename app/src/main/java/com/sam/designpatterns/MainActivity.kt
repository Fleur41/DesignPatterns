package com.sam.designpatterns

import android.os.Bundle
import android.os.Looper
import android.os.Handler
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModelProvider
import com.sam.designpatterns.memory_leak.MemoryLeakScreen
import com.sam.designpatterns.memory_leak.MemoryLeakViewModel
import com.sam.designpatterns.memory_leak.MemoryLeakViewModelFactory
import com.sam.designpatterns.ui.theme.DesignPatternsTheme
import com.sam.mylibrary.fancyLog
//import com.squareup.leakcanary.core.BuildConfig
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

        val runnable = Runnable {
            Log.d("TAG", "onCreate: This will be printed after 5 seconds")
            fancyLog("This will also be printed after 5 seconds, but from library module")
            BuildConfig.DEVELOPER_NAME
            BuildConfig()
        }

        val mainThreadLooper = Looper.getMainLooper()
        val handler = Handler(mainThreadLooper)
        handler.postDelayed(runnable, 5000)
    }
    override fun onDestroy(){
        lifecycle.removeObserver(myObserver)
        super.onDestroy()
    }
}

