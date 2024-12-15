package ec.edu.uce.laverdejhon_paymentjakarta.Services;

import ec.edu.uce.laverdejhon_paymentjakarta.entity.Customer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class OrderService {

    EntityManagerFactory emp = Persistence.createEntityManagerFactory("EntityP");
    EntityManager em = emp.createEntityManager();

    public OrderService() {}

    public void delete(long id){
        em.remove(em.find(Customer.class, id));
    }

    public List<Object[]> customerInformation(String name) {
        String jpql = "SELECT c.name, c.address, p.name, p.price, o.date, op.subtotal, c.payment " +
                "FROM Customer c JOIN c.orders o JOIN o.orderProducts op JOIN op.product p " +
                "WHERE c.name = :name";
         return em.createQuery(jpql, Object[].class).setParameter("name",name).getResultList();
    }
    //--> find customer by name his all information
    public String finalInformation(String name2){
        List<Object[]> results = customerInformation(name2);
        StringBuilder resultBuilder = new StringBuilder();

        for (Object[] row : results) {
            String customerName = (String) row[0];
            String customerAddress = (String) row[1];
            String productName = (String) row[2];
            Double productPrice = (Double) row[3];
            LocalDateTime orderDate = (LocalDateTime) row[4];
            Double subtotal = (Double) row[5];
            String payment = (String) row[6];

            resultBuilder.append("Customer: ").append(customerName)
                    .append(", Address: ").append(customerAddress)
                    .append(", Product: ").append(productName)
                    .append(", Price: $").append(productPrice)
                    .append(", Order Date: ").append(orderDate)
                    .append(", Subtotal: $").append(subtotal)
                    .append(", Payment: ").append(payment)
                    .append("\n");
        }
        return resultBuilder.toString();
    }
}
