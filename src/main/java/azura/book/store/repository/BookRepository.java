package azura.book.store.repository;

import azura.book.store.model.Book;
import java.util.List;

public interface BookRepository {
    Book save(Book book);
    List findAll();
}
