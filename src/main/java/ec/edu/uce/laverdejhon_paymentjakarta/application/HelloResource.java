package ec.edu.uce.laverdejhon_paymentjakarta.application;


import ec.edu.uce.laverdejhon_paymentjakarta.entity.Customer;
import ec.edu.uce.laverdejhon_paymentjakarta.entity.CustomerService;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/test")
public class HelloResource {



    //--> Delete customer
    //--> ARREGLAR EL DELETE :)
    @Path("/delete={id}")
    @GET
    @Produces("text/plain")
    @Transactional
    public String deleteCustomer(@PathParam("id")int id){

        CustomerService cs = new CustomerService();
        cs.delete(id);
        return "Se ha elimiando el customer"+ id;
    }

    //--> Dinamismo con el APIRest


    @Path("/id={id}/name={name}/address={address}")
    @GET
    @Produces("text/plain")
    @Transactional
    public String createCustomerV2(@PathParam("id")long id, @PathParam("name")String name,
                                        @PathParam("address") String address){

        EntityManagerFactory emp = Persistence.createEntityManagerFactory("EntityP");
        EntityManager em = emp.createEntityManager();
        CustomerService cs = new CustomerService(em);

        if (id ==0 || name == null){
            return "Te olvidaste de poner el id y el nombre :))";

        }else {
            cs.create(new Customer(id, name,address, "paypalpayment",
                    "super", "1000"));
        }
        return cs.toString();
    }




}