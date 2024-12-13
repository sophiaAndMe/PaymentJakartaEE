package ec.edu.uce.laverdejhon_paymentjakarta.entity;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@Entity
@Table(name = "OrderProduct",schema = "paymentdb")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idOrderProduct;

    @ManyToOne
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "FK_OrderProduct_product"),
            nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id",foreignKey = @ForeignKey(name = "FK_OrderProduct_order"),
            nullable = false)
    private Order order;

    //--> voy a ponerlo true
    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double subtotal;


    public OrderProduct() {

    }



}
