package ec.edu.uce.laverdejhon_paymentjakarta.Services;

import ec.edu.uce.laverdejhon_paymentjakarta.entity.Customer;
import ec.edu.uce.laverdejhon_paymentjakarta.entity.Product;
import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.SynchronizationType;
import jakarta.transaction.Transactional;

@Stateful
public class ProductService {


    @PersistenceContext(unitName = "EntityP", synchronization = SynchronizationType.SYNCHRONIZED)
    EntityManager em;

    @Inject
    Product product;

    public ProductService() {}


    //--> Connection to db trought nameUnity from persistence.xml
//    public ProductService(EntityManager em) {
//        this.em = em;
//
//    }

    //--> CRUD, Create
    public void create(Product product) {
        this.product = product;
        em.persist(product);
    }

    //--> Delete

    public void delete(long id){
        em.remove(em.find(Customer.class, id));
    }

    @Override
    public String toString() {
        return "{INFORMACION DE PAGO: "
                + product.getId()+'}';
    }
}
