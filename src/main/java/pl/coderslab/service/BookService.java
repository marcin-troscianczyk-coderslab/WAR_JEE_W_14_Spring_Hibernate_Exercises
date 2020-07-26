package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.repository.BookRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public Book addBook(String title, int rating, String description, Publisher publisher) {

        Book book = bookRepository.addBook(title, rating, description, publisher);

        return book;
    }

    @Transactional
    public Book findBookById(long bookId) {
        return bookRepository.findBookById(bookId);
    }

    @Transactional
    public List<Book> findAllBooks() {
        return bookRepository.findAllBooks();
    }

    @Transactional
    public List<Book> getRatingList(int rating) {
        return bookRepository.getRatingList(rating);
    }

    @Transactional
    public Book updateBook(long bookId, String newTitle) {
        return bookRepository.updateBook(bookId, newTitle);
    }

    @Transactional
    public Book removeBook(long bookId) {
        return bookRepository.removeBook(bookId);
    }
}
