package application.service;

import application.dto.BookDto;
import application.dto.CreateBookRequestDto;
import application.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();

    List<Book> getAll();

    BookDto getBookById(Long id);

    BookDto createBook(CreateBookRequestDto bookDto);
}
