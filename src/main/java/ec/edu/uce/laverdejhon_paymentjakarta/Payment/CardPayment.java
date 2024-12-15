package ec.edu.uce.laverdejhon_paymentjakarta.Payment;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CardPayment implements IPayment{


    @Override
    public String pay(String typePayment, String to, double price) {
        return String.format("""
                TypePayment: %s
                to: %s
                """,typePayment,to,price);

    }
}
