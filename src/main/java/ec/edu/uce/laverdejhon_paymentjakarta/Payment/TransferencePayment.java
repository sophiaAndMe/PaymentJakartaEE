package ec.edu.uce.laverdejhon_paymentjakarta.Payment;

public class TransferencePayment implements IPayment{

    @Override
    public String pay(String typePayment, String to, double price) {
        return String.format("""
                TypePayment: %s
                to: %s
                """,typePayment,to,price);

    }
}