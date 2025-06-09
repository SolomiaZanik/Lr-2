package Library.service;
import Library.model.Reader;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReaderService {
    private final Map<Long, Reader> readers = new HashMap<>();
    private Long nextId = 1L;

    public List<Reader> findAll() {
        return new ArrayList<>(readers.values());
    }

    public Optional<Reader> findById(Long id) {
        return Optional.ofNullable(readers.get(id));
    }

    public Reader save(Reader reader) {
        if (reader.getId() == null) {
            reader.setId(nextId++);
        }
        readers.put(reader.getId(), reader);
        return reader;
    }

    public void deleteById(Long id) {
        readers.remove(id);
    }
}
