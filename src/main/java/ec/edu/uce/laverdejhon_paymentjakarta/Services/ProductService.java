package ec.edu.uce.laverdejhon_paymentjakarta.Services;

import ec.edu.uce.laverdejhon_paymentjakarta.entity.Customer;
import ec.edu.uce.laverdejhon_paymentjakarta.entity.Product;
import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Stateful
public class ProductService {


    EntityManagerFactory emp = Persistence.createEntityManagerFactory("EntityP");
    EntityManager em = emp.createEntityManager();

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

    public String getToStringByOrder(){
        return product.toString();
    }

}
