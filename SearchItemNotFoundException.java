public class SearchItemNotFoundException extends RuntimeException {
   public SearchItemNotFoundException(Long id) {
       super("SearchItem not found with id: " + id);
   }
}
