import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

   @Autowired
   private OrderRepository orderRepository;

   public Order placeOrder(User user, List<Product> products, double totalAmount) {
       Order order = new Order();
       order.setUser(user);
       order.setProducts(products);
       order.setOrderDate(new Date());
       order.setTotalAmount(totalAmount);

       return orderRepository.save(order);
   }

   public List<Order> getAllOrdersByUser(User user) {
       return orderRepository.findByUser(user);
   }

   public Order getOrderById(Long orderId) {
       return orderRepository.findById(orderId)
               .orElseThrow(() -> new OrderNotFoundException("Order with ID " + orderId + " not found"));
   }
}
