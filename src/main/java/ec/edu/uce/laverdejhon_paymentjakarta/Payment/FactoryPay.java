package ec.edu.uce.laverdejhon_paymentjakarta.Payment;

import java.util.Locale;

public class FactoryPay {

    public static String FactoryP(String pay, String to, double price){

        if(pay==null){
            return null;
        }else{
            switch (pay.toLowerCase()){
                case "cardpayment":

                    return new CardPayment().pay( pay,to, price);
                case "paypalpayment":

                    return new PayPalPayment().pay(pay, to, price);
                    default:
                        throw new IllegalArgumentException("Unsupported payment type" + pay);
            }



        }



    }

}
