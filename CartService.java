import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

   @Autowired
   private CartItemRepository cartItemRepository;

   @Autowired
   private OrderRepository orderRepository; // Assuming you have an OrderRepository

   public CartItem addToCart(CartItem item) {
       // Implement logic to add an item to the cart
       return cartItemRepository.save(item);
   }

   public List<CartItem> getCartItems(Long userId) {
       // Implement logic to retrieve cart items for a user
       return cartItemRepository.findByUserId(userId);
   }

   public void clearCart(Long userId) {
       // Implement logic to clear cart items for a user
       List<CartItem> userCartItems = cartItemRepository.findByUserId(userId);
       cartItemRepository.deleteAll(userCartItems);
   }

   public void placeOrder(List<CartItem> items, Long userId) {
       // Create an Order entity and populate it with cart items
       Order order = new Order();
       order.setUserId(userId);
       order.setOrderItems(items);

       // Implement logic to calculate the total price and set other order details

       // Save the order to the database
       orderRepository.save(order);

       // Optionally, you can update order status or perform other actions

       // Clear the user's cart
       clearCart(userId);
   }
}
