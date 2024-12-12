package ec.edu.uce.laverdejhon_paymentjakarta.application;


import ec.edu.uce.laverdejhon_paymentjakarta.Services.CustomerService;
import ec.edu.uce.laverdejhon_paymentjakarta.Services.OrderProductService;
import ec.edu.uce.laverdejhon_paymentjakarta.Services.ProductService;
import ec.edu.uce.laverdejhon_paymentjakarta.entity.*;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;

import java.sql.Date;

@Path("/test")
public class HelloResource {

    @Path("/all")
    @GET
    @Produces("text/plain")
    public String allCustomer(){
        CustomerService cs = new CustomerService();
        cs.getAllCustomer();
        return cs.getAllCustomer().toString();
    }

    //--> Delete customer
    @GET
    @Path("/{id}")
    @Produces("text/plain")
    @Transactional
    public String deleteCustomer(@PathParam("id")long id){
        CustomerService cs = new CustomerService();
        cs.delete(id);
        return "Se ha elimiando el customer" + id;
    }

    @Path("/name={name}/address={address}")
    @GET
    @Produces("text/plain")
    @Transactional
    public String createCustomerByOrder(@PathParam("name")String name,
                                        @PathParam("address") String address){
        CustomerService cs = new CustomerService();
        cs.create(new Customer(name,address, "paypalpayment",
                "super", "1000"));
        return cs.getToStringByCustomer();
    }

    @Path("/order/{name}&{address}&{payment}&{product}&{amount}")
    @GET
    @Produces("text/plain")
    @Transactional
    public String createOrder_Product(@PathParam("name") String name,
                                      @PathParam("address") String address,
                                      @PathParam("payment") String payment,
                                      @PathParam("product") String product,
                                      @PathParam("amount") String amount){

        CustomerService cs = new CustomerService();
        cs.create(new Customer(name, address,payment,"TUTI",amount));

        ProductService ps = new ProductService();
        ps.create(new Product(product, amount));

        OrderProductService ops = new OrderProductService();

        OrderProduct op = new OrderProduct();
        op.setAmount(amount);
        ops.create(op);

        return  cs.getToStringByCustomer()+ ps.getToStringByOrder();
    }



}