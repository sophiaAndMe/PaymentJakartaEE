package ec.edu.uce.laverdejhon_paymentjakarta.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
@Setter
@Getter
@Entity
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private long id;

    @Id
    @Column(name = "id_product")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    private String amount;
    private Date date;

    public OrderProduct() {

    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer one_customer;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product products;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderP order_product;

}
