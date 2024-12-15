package ec.edu.uce.laverdejhon_paymentjakarta.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "OrderP", schema = "paymentdb")
public class Order {

    @Id
    @Column(name = "id_order")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime date = LocalDateTime.now();

    // muchos a uno --> Customer
    // siendo la FK usamos .PERSIST para que customer lo persista en la db automaticamente
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id",foreignKey = @ForeignKey(name = "FK_Order_Customer"),
                nullable = false)
    private Customer customer;

    // uno a muchos --> orderProducts
    @OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE)
    private List<OrderProduct> orderProducts;

    @Column(nullable = false)
    private Double totalAmount;

    public Order() {
        this.orderProducts = new ArrayList<>();
    }


}
