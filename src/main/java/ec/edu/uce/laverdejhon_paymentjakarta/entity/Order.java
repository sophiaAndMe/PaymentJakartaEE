package ec.edu.uce.laverdejhon_paymentjakarta.entity;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@ToString
@Setter
@Getter
@Table(name = "OrderP", schema = "paymentdb")
public class Order {

    @Id
    @Column(name = "id_order")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime date = LocalDateTime.now();

    public Order() {}


    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(nullable = false)
    private Double totalAmount;

    public Order(Customer customer, double v) {
    }


}
