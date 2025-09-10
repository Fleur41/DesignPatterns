package com.sam.designpatterns.memory_leak

import android.app.Activity
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sam.designpatterns.MainActivity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.sam.designpatterns.R
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import jakarta.inject.Inject
import java.lang.ref.WeakReference

@HiltViewModel
class MemoryLeakViewModel @Inject constructor(
    //val context: Context,
    @ApplicationContext private val context: Context,
    //val activity: WeakReference<Activity>
) : ViewModel() {
    private val _resourceString = MutableStateFlow<String?>(null)
    val resourceString: StateFlow<String?> get() = _resourceString.asStateFlow()

    init {
        _resourceString.value = context.getString(R.string.memory_leak_example)
    }
}

//Factory
class MemoryLeakViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MemoryLeakViewModel::class.java)) {
            // Pass the application context to the ViewModel
            return MemoryLeakViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}
