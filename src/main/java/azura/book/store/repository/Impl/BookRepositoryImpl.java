package azura.book.store.repository.Impl;

import azura.book.store.model.Book;
import azura.book.store.repository.BookRepository;

import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public List findAll() {
        return List.of();
    }
}
