package ec.edu.uce.laverdejhon_paymentjakarta.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity
@ToString
@Setter
@Getter
public class OrderPayment {

    @Id
    @Column(name = "id_order")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date dia;

    private long id_customer;

    public OrderPayment() {}

    @ManyToOne
    @JoinColumn(name = "id_cus")
    private Customer customer;

    @ManyToMany
    private List<Product> products;


}
