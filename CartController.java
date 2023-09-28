import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

   @Autowired
   private CartService cartService;

   @PostMapping("/add")
   public ResponseEntity<CartItem> addToCart(@RequestBody CartItem item) {
       CartItem addedItem = cartService.addToCart(item);
       return ResponseEntity.ok(addedItem);
   }

   @GetMapping("/items/{userId}")
   public ResponseEntity<List<CartItem>> getCartItems(@PathVariable Long userId) {
       List<CartItem> cartItems = cartService.getCartItems(userId);
       return ResponseEntity.ok(cartItems);
   }

   @DeleteMapping("/clear/{userId}")
   public ResponseEntity<?> clearCart(@PathVariable Long userId) {
       cartService.clearCart(userId);
       return ResponseEntity.ok().build();
   }

   @PostMapping("/order")
   public ResponseEntity<?> placeOrder(@RequestBody List<CartItem> items) {
       cartService.placeOrder(items);
       return ResponseEntity.ok().build();
   }
}
