package ec.edu.uce.laverdejhon_paymentjakarta.Payment;

public class PayPalPayment implements IPayment {
    @Override
    public String pay(String typePayment, String to, String NumberPay) {
        return String.format("""
                TypePayment: %s
                to: %s
                BP: %s
                """,typePayment,to,NumberPay);

    }
}
