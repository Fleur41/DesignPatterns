package com.sam.designpatterns.design_patterns

enum class Country {
    India,
    USA,
    Russia,
    Kenya
}

interface Currency{
    val code: String
    val symbol: String

}

fun main() {
    val currencyFactory = CurrencyFactory()
    val indiaCurrency = currencyFactory.createCurrency(Country.India)
    val usaCurrency = currencyFactory.createCurrency(Country.USA)
    val russiaCurrency = currencyFactory.createCurrency(Country.Russia)
    val kenyaCurrency = currencyFactory.createCurrency(Country.Kenya)

    println("India Currency: ${indiaCurrency.code} ${indiaCurrency.symbol}")
    println("USA Currency: ${usaCurrency.code} ${usaCurrency.symbol}")
    println("Russia Currency: ${russiaCurrency.code} ${russiaCurrency.symbol}")
    println("Kenya Currency: ${kenyaCurrency.code} ${kenyaCurrency.symbol}")
}
