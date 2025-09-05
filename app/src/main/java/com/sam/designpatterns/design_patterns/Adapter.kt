package com.sam.designpatterns.design_patterns

interface PaymentProcessor{
    fun upiPayment(amount: Int)
    fun processCreditCardPayment(amount: Int)
}

class UpiPaymentProcessor(): PaymentProcessor{
    override fun upiPayment(amount: Int) {
        println("UPI Payment of $amount processed")
    }

    override fun processCreditCardPayment(amount: Int) {
        throw UnsupportedOperationException("UPI does not process credit card payments")
    }

}

class CreditCardPaymentProcessor(): PaymentProcessor{
    override fun upiPayment(amount: Int) {
        throw UnsupportedOperationException("Credit Card does not support UPI payments")
    }

    override fun processCreditCardPayment(amount: Int) {
        println("Credit Card Payment of $amount processed")
    }
}

enum class PaymentType{
    UPI,
    CreditCard
}
interface UnifiedPaymentProcessor{
    fun processPayment(paymentType: PaymentType, amount: Int )
}

class UnifiedPaymentProcessorImpl(): UnifiedPaymentProcessor{
    override fun processPayment(paymentType: PaymentType, amount: Int )
     {
        val adapter = PaymentAdapter(paymentType)
         adapter.processPayment(paymentType, amount)
    }
}

class PaymentAdapter(paymentType: PaymentType): UnifiedPaymentProcessor{
    val paymentProcessor = when(paymentType){
        PaymentType.UPI -> UpiPaymentProcessor()
        PaymentType.CreditCard -> CreditCardPaymentProcessor()
    }
    override fun processPayment(paymentType: PaymentType, amount: Int)
    {
        when(paymentType){
            PaymentType.UPI -> paymentProcessor.upiPayment(amount)
            PaymentType.CreditCard -> paymentProcessor.processCreditCardPayment(amount)
        }
    }

}
fun main() {
    val paymentProcessor = UnifiedPaymentProcessorImpl()
    paymentProcessor.processPayment(PaymentType.UPI, 200)
    paymentProcessor.processPayment(PaymentType.CreditCard, 300)
}