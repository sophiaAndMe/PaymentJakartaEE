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
public class OrderP {

    @Id
    @Column(name = "id_order")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date dia;

    public OrderP() {}

    @ManyToOne
    @JoinColumn(nullable = false)
    private Customer customer_order;

    @OneToMany(mappedBy = "order_product")
    private List<OrderProduct> order_product;

    @ManyToMany
    private List<Product> products;




}
