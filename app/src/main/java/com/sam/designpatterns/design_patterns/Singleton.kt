package com.sam.designpatterns.design_patterns

import kotlin.random.Random

//class Singleton {
//    companion object{
//        var instance: Singleton? = null
//        fun getInstance(): Singleton? {
//            if (instance == null) {
//                instance = Singleton()
//            }
//            return instance
//
//        }
//    }
//}

class TestClass {
    val number : Int
    get() = Random.nextInt(10, 100)
}

fun main() {
    val instance1 = TestClass()
    val instance2 = TestClass()
    println(" instance1 == instance2: ${ instance1 == instance2 }")
    println(" instance1 ${ instance1.number }")
    println(" instance2 ${ instance2.number }")

}