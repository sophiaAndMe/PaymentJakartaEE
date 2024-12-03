package ec.edu.uce.laverdejhon_paymentjakarta.application;

import ec.edu.uce.laverdejhon_paymentjakarta.Payment.CardPayment;
import ec.edu.uce.laverdejhon_paymentjakarta.entity.Customer;
import ec.edu.uce.laverdejhon_paymentjakarta.entity.CustomerService;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/test")
public class HelloResource {



    @Path("/create")
    @GET
    @Produces("text/plain")
    @Transactional
    public String createCustomer() {
        EntityManagerFactory emp = Persistence.createEntityManagerFactory("EntityP");
        EntityManager em = emp.createEntityManager();
        CustomerService cs = new CustomerService(em);
        cs.create(new Customer(1,"Jhon","@example.com",
                "PaypalPayment","SuperMaxi","500"));

        return cs.toString();
    }

    @Path("/pay")
    @GET
    @Produces("text/plain")
    public String payment() {
        return null;
    }


}