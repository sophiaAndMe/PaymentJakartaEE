package ec.edu.uce.laverdejhon_paymentjakarta.application;


import ec.edu.uce.laverdejhon_paymentjakarta.Services.CustomerService;
import ec.edu.uce.laverdejhon_paymentjakarta.Services.OrderProductService;
import ec.edu.uce.laverdejhon_paymentjakarta.Services.OrderService;
import ec.edu.uce.laverdejhon_paymentjakarta.entity.*;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.time.LocalDateTime;

@Path("/manager")
public class HelloResource {

    @Inject
    private CustomerService cs;
    @Inject
    private OrderService os;

    @Inject
    private OrderProductService ops;

    //
    @Path("/allCustomer")
    @GET
    @Produces("text/plain")
    public String allCustomer(){
        return cs.getFormattedCustomers();
    }

    //--> update
    //
    @GET
    @Path("/updateCustomer/{id}&{name}&{address}")
    @Produces("text/plain")
    public Response updateCustomer(@PathParam("id") Long id,
                                   @PathParam("name") String name,
                                   @PathParam("address") String address) {
        try {
            cs.updateCustomer(id, name, address);
            return Response.ok("Se ha actualizado la informacion del cliente").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Customer no encontrado").build();
        }
    }
    @GET
    @Path("/listName/{name}")
    @Produces("text/plain")
    @Transactional
    public String findCustomer(@PathParam("name")String name){
        return "Se han encontrado estos clientes... " + "\n" + os.getByName(name);
    }
    //--> Delete customer
    //
    @GET
    @Path("/delete/{id}")
    @Produces("text/plain")
    @Transactional
    public String deleteCustomer(@PathParam("id")long id){
        os.delete(id);
        return "Se ha elimiando el customer" + id;
    }

    //--> Information Completed
    //
    @GET
    @Path("/allInformation/{name}")
    @Produces("text/plain")
    @Transactional
    public String getAllInformation(@PathParam("name") String name){
        return os.finalInformation(name);
    }

    //
    @Path("/create/{name}&{address}&{payment}&{product}&{price}")
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