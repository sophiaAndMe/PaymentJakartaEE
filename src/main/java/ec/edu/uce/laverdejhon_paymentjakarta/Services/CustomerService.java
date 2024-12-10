package ec.edu.uce.laverdejhon_paymentjakarta.Services;

import ec.edu.uce.laverdejhon_paymentjakarta.entity.Customer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CustomerService {

    @PersistenceContext
    EntityManager em;

    @Inject
    Customer customer;

    public CustomerService() {}


    //--> Connection to db trought nameUnity from persistence.xml
    public CustomerService(EntityManager em) {
        this.em = em;

    }

    //--> CRUD, Create
    @Transactional
    public void create(Customer customer) {
        this.customer = customer;
        em.persist(customer);
    }

    //--> Delete

    public void delete(long id){
        em.remove(em.find(Customer.class, id));
    }

    @Override
    public String toString() {
        return "{INFORMACION DE PAGO: "
                + customer.getPayment()+
                "\nEmail: " +  customer.getAddress() +'}';
    }
}
