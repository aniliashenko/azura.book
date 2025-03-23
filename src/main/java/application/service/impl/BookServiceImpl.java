package application.service.impl;

import application.dto.BookDto;
import application.dto.CreateBookRequestDto;
import application.mapper.BookMapper;
import application.model.Book;
import application.repository.BookRepository;
import application.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return null;
//        return bookRepository.findAll().stream().map(BookMapper::toDto).toList();
    }

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public BookDto getBookById(Long id) {
        return bookRepository.getBookById(id);
    }

    @Override
    public BookDto createBook(CreateBookRequestDto bookDto) {
        return bookRepository.createBook(bookDto);
    }
}
