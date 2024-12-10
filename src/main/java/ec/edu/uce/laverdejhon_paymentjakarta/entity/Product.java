package ec.edu.uce.laverdejhon_paymentjakarta.entity;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@ApplicationScoped
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private long id;
    @Column
    private String name;
    @Column
    private String amount;


    public Product() {}

    public Product( String name, String amount) {

        this.name = name;
        this.amount = amount;
    }


    @ManyToMany(mappedBy = "products")
    private List<OrderPayment> orderPayments;



}
