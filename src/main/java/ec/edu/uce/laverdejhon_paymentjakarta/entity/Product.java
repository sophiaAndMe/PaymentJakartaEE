package ec.edu.uce.laverdejhon_paymentjakarta.entity;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(schema = "paymentdb") // especificamos el schema
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private long idProduct;

    @Column
    private String name;
    @Column
    private double price;


    public Product() {}


}
