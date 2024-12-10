package ec.edu.uce.laverdejhon_paymentjakarta.application;


import ec.edu.uce.laverdejhon_paymentjakarta.Services.CustomerService;
import ec.edu.uce.laverdejhon_paymentjakarta.Services.ProductService;
import ec.edu.uce.laverdejhon_paymentjakarta.entity.*;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;

@Path("/test")
public class HelloResource {


    //--> Delete customer
    @GET
    @Path("/{id}")
    @Produces("text/plain")
    @Transactional
    public String deleteCustomer(@PathParam("id")long id){

        EntityManagerFactory emp = Persistence.createEntityManagerFactory("EntityP");
        EntityManager em = emp.createEntityManager();
        CustomerService cs = new CustomerService(em);
        cs.delete(id);
        return "Se ha elimiando el customer" + id;
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

            cs.create(new Customer(name,address, "paypalpayment",
                    "super", "1000"));

        return cs.toString();
    }

//    @Inject
//    ProductService productService;

    @Path("/order")
    @GET
    public String createOrder(){


        ProductService ps = new ProductService();
        ps.create(new Product("camaron","500"));
        return ps.toString();
    }




}