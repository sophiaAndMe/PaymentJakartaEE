package ec.edu.uce.laverdejhon_paymentjakarta.application;


import ec.edu.uce.laverdejhon_paymentjakarta.Services.CustomerService;
import ec.edu.uce.laverdejhon_paymentjakarta.Services.OrderProductService;
import ec.edu.uce.laverdejhon_paymentjakarta.Services.OrderService;
import ec.edu.uce.laverdejhon_paymentjakarta.Services.ProductService;
import ec.edu.uce.laverdejhon_paymentjakarta.entity.*;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;

import java.sql.Date;

@Path("/test")
public class HelloResource {

    @Inject
    private CustomerService cs;
    @Inject
    private OrderService os;
    @Inject
    private ProductService ps;
    @Inject
    private OrderProductService ops;

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

    @GET
    @Path("/order")
    @Produces("text/plain")
    @Transactional
    //--> problema con el order
    public String creteOrder(){

        os.create(new Order(new Customer("name",
                "aa", "cardpayment", "tu prima", 5546), 5.5));
        return "Se ha elimiando el customer";
    }

    @Path("/name={name}/address={address}")
    @GET
    @Produces("text/plain")
    @Transactional
    public String createCustomerByOrder(@PathParam("name")String name,
                                        @PathParam("address") String address){

        cs.create(new Customer(name, address,"paypalpayment", "super",
                555.55));
        return cs.getToStringByCustomer();
    }



    @Path("/{name}&{address}&{payment}&{product}&{price}")
    @GET
    @Produces("text/plain")
    @Transactional
    public String createOrder_Product(@PathParam("name") String name,
                                      @PathParam("address") String address,
                                      @PathParam("payment") String payment,
                                      @PathParam("product") String product,
                                      @PathParam("price") double price){

        Product product1 = new Product();
        product1.setName(product);
        product1.setPrice(price);
        ps.create(product1);

        Customer customer = new Customer();
        customer.setName(name);
        customer.setAddress(address);
        customer.setPayment(payment);
        cs.create(customer);

        Order order1 = new Order();
        order1.setCustomer(customer);
        order1.setDate(order1.getDate());
        order1.setTotalAmount(price);
        os.create(order1);


        OrderProduct op = new OrderProduct();
        op.setOrder(order1);
        op.setProduct(product1);
        op.setQuantity(2);
        op.setSubtotal(2* price);
        ops.create(op);

        return  cs.getToStringByCustomer()+ ps.getToStringByOrder();
    }



}