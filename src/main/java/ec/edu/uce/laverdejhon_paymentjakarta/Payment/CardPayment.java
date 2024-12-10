package ec.edu.uce.laverdejhon_paymentjakarta.Payment;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CardPayment implements IPayment{


    @Override
    public String pay( String fromName, String to, String NumberPay) {
        return String.format("""
                name: %s
                to: %s
                BP: %s:
                """,fromName,to,NumberPay);

    }
}
