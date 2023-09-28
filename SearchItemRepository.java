import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchItemRepository extends JpaRepository<SearchItem, Long> {
   // Define custom query methods if needed
}
