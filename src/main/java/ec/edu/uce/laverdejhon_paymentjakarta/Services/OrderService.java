package ec.edu.uce.laverdejhon_paymentjakarta.Services;

import ec.edu.uce.laverdejhon_paymentjakarta.entity.Order;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class OrderService {

    EntityManagerFactory emp = Persistence.createEntityManagerFactory("EntityP");
    EntityManager em = emp.createEntityManager();

    @Inject
    Order order;

    public OrderService() {}


    @Transactional
    public void create(Order order) {
        this.order = order;
        em.persist(order);
    }

    //--> Delete
//
//    public void delete(long id){
//        em.remove(em.find(Customer.class, id));
//    }


}
