package StrategyPatternExample;

public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        PaymentStrategy creditCardPayment = new CreditCardPayment("2563 2158 1024 2210", "Ashish Kumar", "799",
                "09/27");
        paymentContext.setPaymentStrategy(creditCardPayment);
        paymentContext.pay(1149.0);

        System.out.println("");

        PaymentStrategy payPalPayment = new PayPalPayment("kumarasish42@gmail.com", "ashish@123");
        paymentContext.setPaymentStrategy(payPalPayment);
        paymentContext.pay(2201.0);
    }

}
