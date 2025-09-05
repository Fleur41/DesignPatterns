package com.sam.designpatterns.design_patterns

private class IndianCurrency: Currency{
    override val code: String = "INR"
    override val symbol: String = "₹"
}

private class RussianCurrency: Currency{
    override val code: String = "RUB"
    override val symbol: String = "₽"
}

private class USACurrency: Currency{
    override val code: String = "USD"
    override val symbol: String = "$"
}

private class KenyanCurrency: Currency{
    override val code: String = "KES"
    override val symbol: String = "Ksh"
}

class CurrencyFactory {
    fun createCurrency(country: Country): Currency {
        return when(country){
            Country.India -> IndianCurrency()
            Country.Russia -> RussianCurrency()
            Country.USA -> USACurrency()
            Country.Kenya -> KenyanCurrency()
        }
    }
}