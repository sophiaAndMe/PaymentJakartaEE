package ec.edu.uce.laverdejhon_paymentjakarta.entity;
import ec.edu.uce.laverdejhon_paymentjakarta.Payment.FactoryPay;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@ApplicationScoped
@Table(name = "`CUSTOMER`", schema = "paymentdb")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id_customer")
    private long id;
    @Column (name= "name")
    private String name;
    @Column (name= "adress")
    private String address;
    @Transient
    private String payment;

    public Customer( String name, String address,
                    String payment, String to, String amount) {
        this.name = name;
        this.address = address;
        this.payment = FactoryPay.FactoryP(payment,name,to,amount);
    }

    public Customer() {

    }

    @OneToMany(mappedBy = "customer")
    private List<OrderPayment> orderPayments;

}
