package ec.edu.uce.laverdejhon_paymentjakarta.Payment;

public class PayPalPayment implements IPayment {
    @Override
    public String pay( String fromName, String to, String NumberPay) {
        return String.format("""
                name: %s
                to: %s
                BP: %s:
                """,fromName,to,NumberPay);

    }
}
