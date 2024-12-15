package ec.edu.uce.laverdejhon_paymentjakarta.Payment;

import java.util.Locale;

public class FactoryPay {

    private static final String to = "SuperMaxi";

    public static String FactoryP(String pay, double price){

        if(pay==null){
            return "Ingrese un tipo de pago, por favor";
        }else{
            switch (pay.toLowerCase()){
                case "cardpayment":

                    return new CardPayment().pay( pay,to, price);
                case "paypalpayment":

                    return new PayPalPayment().pay(pay, to, price);
                case "transferencepayment":

                    return new TransferencePayment().pay(pay, to, price);

                    default:
                        throw new IllegalArgumentException("No se admite ese tipo de pago :(.." + pay);
            }



        }



    }

}
