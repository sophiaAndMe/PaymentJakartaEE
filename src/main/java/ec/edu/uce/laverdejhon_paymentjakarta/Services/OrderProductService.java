package ec.edu.uce.laverdejhon_paymentjakarta.Services;

import ec.edu.uce.laverdejhon_paymentjakarta.entity.OrderProduct;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;

public class OrderProductService {

    EntityManagerFactory emp = Persistence.createEntityManagerFactory("EntityP");
    EntityManager em = emp.createEntityManager();

    @Inject
    OrderProduct orderProduct;

    public OrderProductService() {}


    //--> Connection to db trought nameUnity from persistence.xml
    public OrderProductService(EntityManager em) {
        this.em = em;

    }

    //--> CRUD, Create
    @Transactional
    public void create(OrderProduct orderProduct) {
        this.orderProduct = orderProduct;
        em.persist(orderProduct);
    }

    //--> Delete
//
//    public void delete(long id){
//        em.remove(em.find(Customer.class, id));
//    }

    @Override
    public String toString() {
        return "{INFORMACION DE PAGO: "
                + orderProduct.getId()+'}';
    }

}
