package azura.book.store.service;

import azura.book.store.model.Book;
import java.util.List;

public interface BookService {
    Book save(Book book);
    List findAll();
}
