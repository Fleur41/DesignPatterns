package com.sam.designpatterns.design_patterns

class MadFlow<T>(private var value: T) {
    private val observers = mutableListOf<(T) -> Unit>()
    fun collect(observer: (T) -> Unit){
        observers.add(observer)
        observer(value)
    }

    fun update(newValue: T){
        value = newValue
        notifyObservers()
    }

    private fun notifyObservers(){
        observers.forEach {  observer ->
            observer(value)
        }
    }
}

fun main() {
    val madFlow = MadFlow("Initial value")
    madFlow.collect { values ->
        println("Observer 1: $values")
    }

    madFlow.collect { values ->
        println("Observer 2: $values")
    }
    Thread.sleep(2000)

    madFlow.update("New value")

    Thread.sleep(2000)
}