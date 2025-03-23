package application.repository;

import application.dto.BookDto;
import application.dto.CreateBookRequestDto;
import application.model.Book;
import java.util.List;

public interface BookRepository {
    Book save(Book book);

    List<Book> findAll();

    List<Book> getAll();

    BookDto getBookById(Long id);

    BookDto createBook(CreateBookRequestDto bookDto);
}
