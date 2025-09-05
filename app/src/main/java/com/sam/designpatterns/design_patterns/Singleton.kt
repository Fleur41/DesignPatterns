package com.sam.designpatterns.design_patterns

import androidx.compose.ui.graphics.Path
import kotlin.random.Random

class Singleton private constructor() {
   companion object{

        private var instance: Singleton? = null
        fun getInstance(): Singleton {
            if (instance == null) {
                instance = Singleton()
            }
            return instance!!

        }
   }
}

object KotlinSingleton {}
class TestClass {
    val number : Int
    get() = Random.nextInt(10, 100)
}

fun main() {
    val instance1 = TestClass()
    val instance2 = TestClass()
    println(" instance1 == instance2: ${ instance1 == instance2 }")
    println(" instance1.number ${ instance1.number }")
    println(" instance2.number  ${ instance2.number }")

    val singleton1 = Singleton.getInstance()
    val singleton2 = Singleton.getInstance()
    println(" singleton1 == singleton2: ${ singleton1 == singleton2 }")

    val kotlinSingleton1 = KotlinSingleton
    val kotlinSingleton2 = KotlinSingleton
    println(" kotlinSingleton1 == KotlinSingleton2: ${ kotlinSingleton1 == kotlinSingleton2 }")

}