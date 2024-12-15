package ec.edu.uce.laverdejhon_paymentjakarta.Services;

import ec.edu.uce.laverdejhon_paymentjakarta.entity.Customer;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@ApplicationScoped
public class CustomerService {

    EntityManagerFactory emp = Persistence.createEntityManagerFactory("EntityP");
    EntityManager em = emp.createEntityManager();

    @Inject
    Customer customer;

    public CustomerService() {}

    public List<Customer> getAllCustomer(){
        String query = "SELECT c FROM Customer c";
        return em.createQuery(query, Customer.class).getResultList();
    }

    public String getFormattedCustomers() {
        List<Customer> customers = getAllCustomer();
        return customers.stream()
                .map(Customer::toString)  /// Llama al metodo toString de cada objeto
                .collect(Collectors.joining("\n")); // Une cada cliente con un salto de línea
    }


    @Transactional
    public void updateCustomer(Long customerID,String newName, String newAddress ){
        Customer customer1 = em.find(Customer.class, customerID);

        if(customer1 != null){
            customer1.setName(newName);
            customer1.setAddress(newAddress);
            em.merge(customer1);
        }else{
            throw  new RuntimeException("No se ha encontrado un cliente.. con id: "+ customerID);
        }

           }


}
