package ec.edu.uce.laverdejhon_paymentjakarta.entity;
import ec.edu.uce.laverdejhon_paymentjakarta.Payment.FactoryPay;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(schema = "paymentdb")
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
                    String payment, String to, double price) {
        this.name = name;
        this.address = address;
        this.payment = FactoryPay.FactoryP(payment,to,price);
    }

    public Customer() {
    }

    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", payment='" + payment + '\'' +
                '}';
    }
}
