package com.sam.designpatterns.design_patterns

//data class DoughWeightInKg(val weight: Int)
@JvmInline
value class DoughWeightInKg(val weight: Int)
interface Dough{
    val weight: DoughWeightInKg
}

class WheatDough(override val weight: DoughWeightInKg):Dough{
    override fun toString(): String {
        return "WheatDough(weight=$weight)"
    }
}
class GramDough(override val weight: DoughWeightInKg):Dough{
    override fun toString(): String {
        return "GramDough(weight=$weight)"
    }
}

interface Toppings{
    val spiceLevel: Int
}

class Cheese(override val spiceLevel: Int):Toppings{
    override fun toString(): String {
        return "Cheese(spiceLevel=$spiceLevel)"
    }
}
class Onion(override val spiceLevel: Int):Toppings{
    override fun toString(): String {
        return "Onion(spiceLevel=$spiceLevel)"
    }
}

interface Sauce{
    val spiceLevel: Int
}

class TomatoSauce(override val spiceLevel: Int):Sauce{
    override fun toString(): String {
        return "TomatoSauce(spiceLevel=$spiceLevel)"
    }
}
class OnionSauce(override val spiceLevel: Int):Sauce{
    override fun toString(): String {
        return "OnionSauce(spiceLevel=$spiceLevel)"
    }
}

class Pizza private constructor(
    private val dough: Dough,
    private val toppings: List<Toppings>,
    private val sauce: Sauce
){
    class Builder{
        private var dough: Dough = WheatDough(DoughWeightInKg(1))
        private var toppings: List<Toppings> = listOf(Cheese(0))
        private var sauce: Sauce = TomatoSauce(1)

        fun addDough(dough: Dough): Builder {
            this.dough = dough
            return this
        }

        fun addToppings(toppings: List<Toppings>): Builder {
            this.toppings = toppings
            return this
        }

        fun addSauce(sauce: Sauce): Builder {
            this.sauce = sauce
            return this
        }

        fun build(): Pizza{
            return Pizza(dough, toppings, sauce)
        }
    }
    override fun toString(): String {
        return "Pizza(dough=$dough, toppings=$toppings, sauce=$sauce)"
    }
}



fun main() {
    val pizza = Pizza.Builder()
        .addDough(GramDough(DoughWeightInKg(1)))
        .addSauce(OnionSauce(1))
        .build()

    println("Pizza: $pizza")
}