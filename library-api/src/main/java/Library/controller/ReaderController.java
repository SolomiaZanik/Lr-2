package Library.controller;

import Library.model.Reader;
import Library.service.ReaderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/readers")
public class ReaderController {
    private final ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping
    public List<Reader> getAll() {
        return readerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reader> getById(@PathVariable Long id) {
        return readerService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Reader create(@RequestBody Reader reader) {
        return readerService.save(reader);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reader> update(@PathVariable Long id, @RequestBody Reader reader) {
        return readerService.findById(id).map(existing -> {
            reader.setId(id);
            return ResponseEntity.ok(readerService.save(reader));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (readerService.findById(id).isPresent()) {
            readerService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}