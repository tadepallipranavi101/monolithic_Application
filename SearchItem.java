import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SearchItem {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private String description;

   // Constructors
   public SearchItem() {
   }

   public SearchItem(String name, String description) {
       this.name = name;
       this.description = description;
   }

   // Getters and setters
   public Long getId() {
       return id;
   }

   public void setId(Long id) {
this.id = id;
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }

   public String getDescription() {
       return description;
   }

   public void setDescription(String description) {
       this.description = description;
   }

   // Override toString() for debugging purposes
   @Override
   public String toString() {
       return "SearchItem{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", description='" + description + '\'' +
               '}';
   }
}
has context menu
