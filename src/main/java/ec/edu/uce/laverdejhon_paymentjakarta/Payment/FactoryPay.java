package ec.edu.uce.laverdejhon_paymentjakarta.Payment;

import java.util.Locale;

public class FactoryPay {

    public static String FactoryP(String pay, String from, String to, String amount){

        if(pay==null){
            return null;
        }else{

            switch (pay.toLowerCase()){
                case "cardpayment":
                    return new CardPayment().pay(from, to, amount);
                case "paypalpayment":
                    return new PayPalPayment().pay(from, to, amount);
                    default:
                        throw new IllegalArgumentException("Unsupported payment type" + pay);
            }



        }



    }

}
