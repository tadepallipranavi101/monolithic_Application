

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;

import java.util.Map;


@RestController

@RequestMapping("/search")

public class SearchController {


    @Autowired

    private SearchItemService searchItemService;


    @PostMapping("/add")

    public ResponseEntity<SearchItem> add(@RequestBody SearchItem item) {

        SearchItem addedItem = searchItemService.add(item);

        return ResponseEntity.ok(addedItem);

    }


    @GetMapping("/all")

    public ResponseEntity<List<SearchItem>> findAll() {

        List<SearchItem> items = searchItemService.findAll();

        return ResponseEntity.ok(items);

    }


    @GetMapping("/{id}")

    public ResponseEntity<SearchItem> findById(@PathVariable Long id) {

        SearchItem item = searchItemService.findById(id);

        return ResponseEntity.ok(item);

    }


    @GetMapping("/find")

    public ResponseEntity<List<SearchItem>> findByColumns(@RequestParam Map<String, String> params) {

        List<SearchItem> items = searchItemService.findByColumns(params);

        return ResponseEntity.ok(items);

    }


    @PutMapping("/update/{id}")

    public ResponseEntity<SearchItem> update(@PathVariable Long id, @RequestBody SearchItem item) {

        SearchItem updatedItem = searchItemService.update(id, item);

        return ResponseEntity.ok(updatedItem);

    }


    @DeleteMapping("/delete/{id}")

    public ResponseEntity<?> delete(@PathVariable Long id) {

        searchItemService.delete(id);

        return ResponseEntity.ok().build();

    }

}
