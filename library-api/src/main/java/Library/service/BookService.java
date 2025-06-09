package Library.service;

import Library.model.Book;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {
    private final Map<Long, Book> books = new HashMap<>();
    private Long nextId = 1L;

    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(books.get(id));
    }

    public Book save(Book book) {
        if (book.getId() == null) {
            book.setId(nextId++);
        }
        books.put(book.getId(), book);
        return book;
    }

    public void deleteById(Long id) {
        books.remove(id);
    }
}
