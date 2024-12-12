package ec.edu.uce.laverdejhon_paymentjakarta.Services;

import ec.edu.uce.laverdejhon_paymentjakarta.entity.Customer;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;


@Stateless
public class CustomerService {

    EntityManagerFactory emp = Persistence.createEntityManagerFactory("EntityP");
    EntityManager em = emp.createEntityManager();

    @Inject
    Customer customer;

    public CustomerService() {}

    // CRUD

    public void create(Customer customer) {
        this.customer = customer;
        em.persist(customer);
    }

    public void delete(long id){
        em.remove(em.find(Customer.class, id));
    }



    public List<Customer> getAllCustomer(){
        String query = "SELECT c FROM Customer c";
        return em.createQuery(query, Customer.class).getResultList();
    }

    public String getToStringByCustomer(){
        return this.customer.toString();
    }


}
