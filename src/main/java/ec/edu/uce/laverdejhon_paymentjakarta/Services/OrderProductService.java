package ec.edu.uce.laverdejhon_paymentjakarta.Services;

import ec.edu.uce.laverdejhon_paymentjakarta.entity.Customer;
import ec.edu.uce.laverdejhon_paymentjakarta.entity.Order;
import ec.edu.uce.laverdejhon_paymentjakarta.entity.OrderProduct;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class OrderProductService {

    EntityManagerFactory emp = Persistence.createEntityManagerFactory("EntityP");
    EntityManager em = emp.createEntityManager();

    @Inject
    OrderProduct orderProduct;

    public OrderProductService() {}


    //--> CRUD, Create
    @Transactional
    public void create(OrderProduct orderProduct) {
        this.orderProduct = orderProduct;
        em.persist(orderProduct);
    }

    //--> Delete

    public void delete(long id){
        em.remove(em.find(Order.class, id));
    }



}
