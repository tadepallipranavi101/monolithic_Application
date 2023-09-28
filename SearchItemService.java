import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SearchItemService {

   @Autowired
   private SearchItemRepository searchItemRepository;

   public SearchItem add(SearchItem item) {
       return searchItemRepository.save(item);
   }

   public List<SearchItem> findAll() {
       return searchItemRepository.findAll();
   }

   public SearchItem findById(Long id) {
       Optional<SearchItem> optionalItem = searchItemRepository.findById(id);
       return optionalItem.orElseThrow(() -> new SearchItemNotFoundException(id));
   }

   public List<SearchItem> findByColumns(Map<String, String> params) {
       // Implement custom query logic here based on params
       // Example: searchItemRepository.findByColumn1AndColumn2(params.get("column1"), params.get("column2"));
   }

   public SearchItem update(Long id, SearchItem updatedItem) {
       if (!searchItemRepository.existsById(id)) {
           throw new SearchItemNotFoundException(id);
       }
       updatedItem.setId(id);
       return searchItemRepository.save(updatedItem);
   }

   public void delete(Long id) {
       if (!searchItemRepository.existsById(id)) {
           throw new SearchItemNotFoundException(id);
       }
       searchItemRepository.deleteById(id);
   }
}
