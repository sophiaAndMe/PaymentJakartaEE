package ec.edu.uce.laverdejhon_paymentjakarta.entity;
import ec.edu.uce.laverdejhon_paymentjakarta.Payment.FactoryPay;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

// Usando Lombook
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
    @Column (name = "payment")
    private String payment;

    public Customer() {
    }

    // uno a muchos --> Pedidos
    // CascadeType.Remove se encarga de eliminar en cascada
    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    // toString personalizado
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", payment='" + payment + '\'' +
                '}';
    }

    public void setPayment(String payment, double price) {
        this.payment = FactoryPay.FactoryP(payment,price);
    }
}
