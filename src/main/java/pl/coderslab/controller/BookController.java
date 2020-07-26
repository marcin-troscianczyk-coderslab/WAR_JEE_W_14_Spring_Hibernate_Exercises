package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.BookService;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    // GET /books
    @GetMapping(path = "/books", produces = "text/plain;charset=UTF-8")
    String getAllBooks() {

        List<Book> books = bookService.findAllBooks();

        return books.toString();
    }

    @GetMapping(path = "/rbooks", produces = "text/plain;charset=UTF-8")
    String getRatingList(@RequestParam("rating") int rating) {

        List<Book> books = bookService.getRatingList(rating);

        return books.toString();
    }

    // GET /book?id=1
    @GetMapping(path = "/book", produces = "text/plain;charset=UTF-8")
    String getBook(@RequestParam("id") long bookId) {

        Book book = bookService.findBookById(bookId);

        return  book.toString();
    }

    // POST /book title=Ala ma kota&rating=5&description=Fajna książka
    @PostMapping(path = "/book", produces = "text/plain;charset=UTF-8")
    String addBook(
            @RequestParam("title") String title,
            @RequestParam("rating") int rating,
            @RequestParam("description") String description) {

        Publisher publisher = new Publisher();
        publisher.setName("Prószyński i S-ka");

        Book book = bookService.addBook(title, rating, description, publisher);

        return book.toString();

    }

    // PUT /book?id=1&title=Nowy tytuł
    @PutMapping(path = "/book", produces = "text/plain;charset=UTF-8")
    String updateBook(
            @RequestParam("id") long bookId,
            @RequestParam("title") String newTitle) {

        Book book = bookService.updateBook(bookId, newTitle);
        return book.toString();
    }

    // DELETE /book?id=1
    @DeleteMapping(path = "/book", produces = "text/plain;charset=UTF-8")
    String removeBook(@RequestParam("id") long bookId) {

        Book book = bookService.removeBook(bookId);
        return book.toString();
    }
}
