package ec.edu.uce.laverdejhon_paymentjakarta.Services;

import ec.edu.uce.laverdejhon_paymentjakarta.entity.OrderPayment;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class OrderPaymentService {

    EntityManagerFactory emp = Persistence.createEntityManagerFactory("EntityP");
    EntityManager em = emp.createEntityManager();

    @Inject
    OrderPayment orderPayment;

    public OrderPaymentService() {}


    //--> Connection to db trought nameUnity from persistence.xml
    public OrderPaymentService(EntityManager em) {
        this.em = em;

    }

    //--> CRUD, Create
    @Transactional
    public void create(OrderPayment orderPayment) {
        this.orderPayment = orderPayment;
        em.persist(orderPayment);
    }

    //--> Delete
//
//    public void delete(long id){
//        em.remove(em.find(Customer.class, id));
//    }

    @Override
    public String toString() {
        return "{INFORMACION DE PAGO: "
                + orderPayment.getId()+'}';
    }
}
