package application.repository.impl;

import application.model.Book;
import application.repository.BookRepository;
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
