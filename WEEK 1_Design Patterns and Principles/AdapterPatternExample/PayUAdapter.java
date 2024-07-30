package AdapterPatternExample;

public class PayUAdapter implements PaymentProcessor {

    private PayU payu;

    public PayUAdapter(PayU payu) {
        this.payu = payu;
    }

    @Override
    public void processPayment(double amount) {
        payu.charge(amount);

    }

}
