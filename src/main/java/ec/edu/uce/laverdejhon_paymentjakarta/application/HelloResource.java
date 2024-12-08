package ec.edu.uce.laverdejhon_paymentjakarta.application;


import ec.edu.uce.laverdejhon_paymentjakarta.entity.Customer;
import ec.edu.uce.laverdejhon_paymentjakarta.entity.CustomerService;
import ec.edu.uce.laverdejhon_paymentjakarta.entity.OrderPayment;
import ec.edu.uce.laverdejhon_paymentjakarta.entity.OrderPaymentService;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/test")
public class HelloResource {


    @Inject
    CustomerService customerService;

    //--> Delete customer
    //--> ARREGLAR EL DELETE :)
    @GET
    @Path("/delete={id}")
    @Produces("text/plain")
    @Transactional
    public String deleteCustomer(@PathParam("id")long id){
        customerService.delete(id);
        return "Se ha elimiando el customer"+ id;
    }

    //--> Dinamismo con el APIRest


    @Path("/name={name}/address={address}")
    @GET
    @Produces("text/plain")
    @Transactional
    public String createCustomerV2(@PathParam("name")String name,
                                        @PathParam("address") String address){

        EntityManagerFactory emp = Persistence.createEntityManagerFactory("EntityP");
        EntityManager em = emp.createEntityManager();
        CustomerService cs = new CustomerService(em);

        if (name == null){
            return "INGRESA UN NOMBRE ))";

        }else {
            cs.create(new Customer(name,address, "paypalpayment",
                    "super", "1000"));
        }
        return cs.toString();
    }


    @Path("/order")
    @GET
    @Transactional
    public String createOrder(){
        EntityManagerFactory emp = Persistence.createEntityManagerFactory("EntityP");
        EntityManager em = emp.createEntityManager();
        OrderPaymentService orp = new OrderPaymentService(em);

        orp.create(new OrderPayment(1));

        return orp.toString();
    }




}