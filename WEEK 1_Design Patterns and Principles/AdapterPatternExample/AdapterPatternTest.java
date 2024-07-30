package AdapterPatternExample;

public class AdapterPatternTest {
    public static void main(String args[]) {
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPal());
        paypalProcessor.processPayment(100.00);

        PaymentProcessor payuProcessor = new PayUAdapter(new PayU());
        payuProcessor.processPayment(100.00);
    }

}
