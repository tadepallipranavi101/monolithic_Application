import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Order {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @ManyToOne
   private User user;

   @OneToMany
   private List<Product> products;

   private Date orderDate;
   private double totalAmount;

   // Constructors
   public Order() {
   }

   public Order(User user, List<Product> products, Date orderDate, double totalAmount) {
       this.user = user;
       this.products = products;
       this.orderDate = orderDate;
       this.totalAmount = totalAmount;
   }

   // Getters and setters
   public Long getId() {
       return id;
   }

   public void setId(Long id) {
this.id = id;
   }

   public User getUser() {
       return user;
   }

   public void setUser(User user) {
       this.user = user;
   }

   public List<Product> getProducts() {
       return products;
   }

   public void setProducts(List<Product> products) {
       this.products = products;
   }

   public Date getOrderDate() {
       return orderDate;
   }

   public void setOrderDate(Date orderDate) {
       this.orderDate = orderDate;
   }

   public double getTotalAmount() {
       return totalAmount;
   }

   public void setTotalAmount(double totalAmount) {
       this.totalAmount = totalAmount;
   }
}
