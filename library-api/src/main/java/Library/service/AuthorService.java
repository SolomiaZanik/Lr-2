package Library.service;

import Library.model.Author;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthorService {
    private final Map<Long, Author> authors = new HashMap<>();
    private static Long nextId = 1L;

    public List<Author> findAll() {
        return new ArrayList<>(authors.values());
    }

    public Optional<Author> findById(Long id) {
        return Optional.ofNullable(authors.get(id));
    }

    public Author save(Author author) {
        if (author.getId() == null) {
            author.setId(nextId++);
        }
        authors.put(author.getId(), author);
        return author;
    }

    public void deleteById(Long id) {
        authors.remove(id);
    }
}