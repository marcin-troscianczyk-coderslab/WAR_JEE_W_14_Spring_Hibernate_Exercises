package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;
import pl.coderslab.repository.springdata.SpringDataBookRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    /*private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
*/
    private final SpringDataBookRepository bookRepository;

    public BookService(SpringDataBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public Book addBook(String title, int rating, String description, Publisher publisher) {

        //Book book = bookRepository.addBook(title, rating, description, publisher);

        return null;
    }

    @Transactional
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public Book findBookById(long bookId) {
        return bookRepository.findById(bookId)
                .get();
    }

    @Transactional
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public List<Book> findAllBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Transactional
    public List<Book> findAllBooksByCategory(Category category) {
        return bookRepository.findAllByCategory(category);
    }

    @Transactional
    public List<Book> findAllBooksByCategoryId(long idCategory) {
        return bookRepository.findAllBooksByCategoryId(idCategory);
    }

    @Transactional
    public List<Book> getRatingList(int rating) {
        return null;/*bookRepository.getRatingList(rating);*/
    }

    @Transactional
    public Book updateBook(long bookId, String newTitle) {
        return null/*bookRepository.updateBook(bookId, newTitle)*/;
    }

    @Transactional
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public void removeBook(long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Transactional
    public void removeBook(Book book) {
        bookRepository.delete(book);
    }

    // zad 3a
    @Transactional
    public List<Book> findAllBooksByAuthor(Author author) {
        return bookRepository.findAllBooksByAuthors(author);
    }

    // zad 3b
    @Transactional
    public List<Book> findAllBooksByPublisher(Publisher publisher) {
        return bookRepository.findAllBooksByPublisher(publisher);
    }

    // zad 3c
    @Transactional
    public List<Book> findAllBooksByRating(int rating) {
        return bookRepository.findAllBooksByRating(rating);
    }

    // zad 3d
    @Transactional
    public Optional<Book> findFirstBookByCategoryOrderByTitle(Category category) {
        return bookRepository.findFirstBookByCategoryOrderByTitle(category);
    }

    @Transactional
    public List<Book> findAllBooksByRatingBetween(int start, int stop) {
        return bookRepository.findAllBooksByRatingBetween(start, stop);
    }
}
