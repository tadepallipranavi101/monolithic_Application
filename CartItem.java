import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CartItem {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private Long userId;
   private Long productId;
   private int quantity;

   // Constructors
   public CartItem() {
   }

   public CartItem(Long userId, Long productId, int quantity) {
       this.userId = userId;
       this.productId = productId;
       this.quantity = quantity;
   }

   // Getters and setters
   public Long getId() {
       return id;
   }

   public void setId(Long id) {
this.id = id;
   }

   public Long getUserId() {
       return userId;
   }

   public void setUserId(Long userId) {
       this.userId = userId;
   }

   public Long getProductId() {
       return productId;
   }

   public void setProductId(Long productId) {
       this.productId = productId;
   }

   public int getQuantity() {
       return quantity;
   }

   public void setQuantity(int quantity) {
       this.quantity = quantity;
   }
}
