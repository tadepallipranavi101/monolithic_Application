import javax.persistence.*;
import java.util.List;

@Entity
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String username;
   private String password;
   private String fullName;

   @OneToMany(mappedBy = "user")
   private List<DeliveryAddress> deliveryAddresses;

   // Constructors
   public User() {
   }

   public User(String username, String password, String fullName) {
       this.username = username;
       this.password = password;
       this.fullName = fullName;
   }

   // Getters and setters
   public Long getId() {
       return id;
   }

   public void setId(Long id) {
this.id = id;
   }

   public String getUsername() {
       return username;
   }

   public void setUsername(String username) {
       this.username = username;
   }

   public String getPassword() {
       return password;
   }

   public void setPassword(String password) {
       this.password = password;
   }

   public String getFullName() {
       return fullName;
   }

   public void setFullName(String fullName) {
       this.fullName = fullName;
   }

   public List<DeliveryAddress> getDeliveryAddresses() {
       return deliveryAddresses;
   }

   public void setDeliveryAddresses(List<DeliveryAddress> deliveryAddresses) {
       this.deliveryAddresses = deliveryAddresses;
   }
}
