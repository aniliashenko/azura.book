package application;

import application.config.AppConfig;
import application.model.Book;
import application.repository.BookRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BookRepository bookRepository = context.getBean(BookRepository.class);

        // Create and save
        Book book = new Book("1984", "George Orwell", "978-0451524935", new BigDecimal("9.99"));
        book.setDescription("Dystopian novel");
        book.setCoverImage("1984.jpg");
        Book savedBook = bookRepository.save(book);
        System.out.println("Saved: " + savedBook);

        // Find all
        List<Book> books = bookRepository.findAll();
        System.out.println("All books: " + books);

        SpringApplication.run(Application.class, args);
    }
}
