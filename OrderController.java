import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

   @Autowired
   private OrderService orderService;

   @PostMapping("/place")
   public Order placeOrder(@RequestBody PlaceOrderRequest request) {

       User user = userService.getUserById(request.getUserId());
       List<Product> products = productService.getProductsByIds(request.getProductIds());
       double totalAmount = calculateTotalAmount(products); // Implement this method
       Order createdOrder = orderService.placeOrder(user, products, totalAmount);
       return createdOrder;
   }

   @GetMapping("/user/{userId}")
   public List<Order> getAllOrdersByUser(@PathVariable Long userId) {
      
       User user = userService.getUserById(userId);
       List<Order> userOrders = orderService.getAllOrdersByUser(user);
       return userOrders;
   }

   @GetMapping("/{orderId}")
   public Order getOrderById(@PathVariable Long orderId) {
       
       Order order = orderService.getOrderById(orderId);
       return order;
   }

  
}
