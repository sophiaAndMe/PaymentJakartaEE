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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
        return cs.getFormattedCustomers();
    }

    //--> Delete customer
    @GET
    @Path("/{id}")
    @Produces("text/plain")
    @Transactional
    public String deleteCustomer(@PathParam("id")long id){
        os.delete(id);
        return "Se ha elimiando el customer" + id;
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

        Customer customer = new Customer();
        customer.setName(name);
        customer.setAddress(address);
        customer.setPayment(payment);

        Product product1 = new Product();
        product1.setName(product);
        product1.setPrice(price);

        Order order1 = new Order();
        order1.setCustomer(customer);
        order1.setDate(LocalDateTime.now());
        order1.setTotalAmount(price);

        OrderProduct op = new OrderProduct();
        op.setProduct(product1);
        op.setOrder(order1);
        op.setQuantity(2);
        op.setSubtotal(2* price);
        ops.create(op);

        return customer.getName() + " Su compra se ha realizado con exito!!!"
                + "\n" + product1.getName() +" a valor de " + product1.getPrice()
                + "\n" + "Metodo de pago: " + customer.getPayment()
                + "\n" + "GRACIAS POR SU COMPRA, VUELVA PRONTO";
    }



}