package ec.edu.uce.laverdejhon_paymentjakarta.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "OrderProduct",schema = "paymentdb")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idOrderProduct;

    // Usamos .PERSIST para persistir product a la db y hace el programa mas rapido
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "FK_OrderProduct_product"),
            nullable = false)
    private Product product;

    //-- de igual manera que arriba
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "order_id",foreignKey = @ForeignKey(name = "FK_OrderProduct_order"),
            nullable = false)
    private Order order;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double subtotal;

    public OrderProduct() {

    }



}
