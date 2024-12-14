package ec.edu.uce.laverdejhon_paymentjakarta.Services;

import ec.edu.uce.laverdejhon_paymentjakarta.entity.Customer;
import ec.edu.uce.laverdejhon_paymentjakarta.entity.Product;
import jakarta.ejb.Stateful;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@ApplicationScoped
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
    //--> Delete

    public void delete(long id){
        em.remove(em.find(Product.class, id));
    }

    public String getToStringByOrder(){
        return product.toString();
    }

}
