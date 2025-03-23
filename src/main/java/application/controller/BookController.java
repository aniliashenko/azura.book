package application.controller;

import application.dto.BookDto;
import application.dto.CreateBookRequestDto;
import application.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public List getAll() {
        return bookService.getAll();
    }

    public BookDto getBookById(Long id) {
        return bookService.getBookById(id);
    }

    public BookDto createBook(CreateBookRequestDto bookDto) {
        return bookService.createBook(bookDto);
    }
}
