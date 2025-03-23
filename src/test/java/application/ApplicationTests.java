package application;

import application.config.AppConfig;
import application.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Import(AppConfig.class)
class ApplicationTests {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void contextLoads() {
        assertNotNull(bookRepository, "BookRepository should be initialized");
    }
}
