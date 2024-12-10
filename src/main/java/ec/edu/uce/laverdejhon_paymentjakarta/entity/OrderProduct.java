package ec.edu.uce.laverdejhon_paymentjakarta.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
    private long id;

    private long amount;
    private Date date;

    public OrderProduct() {

    }

    @OneToOne
    private Customer customer;

    @ManyToOne
    private Product product;

    @ManyToOne
    private OrderPayment orderPayment;

}
