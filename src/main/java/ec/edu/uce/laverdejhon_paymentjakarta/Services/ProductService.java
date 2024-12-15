package ec.edu.uce.laverdejhon_paymentjakarta.Services;

import ec.edu.uce.laverdejhon_paymentjakarta.entity.Product;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.*;

@ApplicationScoped
public class ProductService {


    EntityManagerFactory emp = Persistence.createEntityManagerFactory("EntityP");
    EntityManager em = emp.createEntityManager();

    @Inject
    Product product;

    public ProductService() {}

    //-- crear producto
    public void createProduct(Product product){
        this.product = product;
        em.persist(product);
    }

}
