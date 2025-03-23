package application.repository.impl;

import application.dto.BookDto;
import application.dto.CreateBookRequestDto;
import application.model.Book;
import application.repository.BookRepository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public BookRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Book save(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }

        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            if (book.getId() == null) {
                // Save new book
                session.save(book);
            } else {
                // Update existing book
                Book existingBook = session.get(Book.class, book.getId());
                if (existingBook != null) {
                    existingBook.setTitle(book.getTitle());
                    existingBook.setAuthor(book.getAuthor());
                    session.update(existingBook);
                    book = existingBook;
                } else {
                    throw new RuntimeException("Book with id " + book.getId() + " not found");
                }
            }

            transaction.commit();
            return book;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to save book: " + e.getMessage(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Book> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Book", Book.class)
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch all books: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Book> getAll() {
        return List.of();
    }

    @Override
    public BookDto getBookById(Long id) {
        return null;
    }

    @Override
    public BookDto createBook(CreateBookRequestDto bookDto) {
        return null;
    }
}
