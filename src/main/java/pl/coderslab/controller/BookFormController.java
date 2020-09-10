package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;
import pl.coderslab.exception.BookNotFoundException;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;
import pl.coderslab.service.CategoryService;
import pl.coderslab.service.PublisherService;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Controller
class BookFormController {

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;

/*    @Autowired
    private Validator validator;*/

    @GetMapping(path = "form/book", produces = "text/html;charset=UTF-8")
    String showAddForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "book/add";
    }

    @PostMapping(path = "form/book", produces = "text/html;charset=UTF-8")
    String processAddForm(@Valid Book book, BindingResult bresult) {


        if (bresult.hasErrors()) {

            return "book/add";
        } else {
            Book result = bookService.addBook(book);
            return "redirect:/form/books";
        }
    }

    @GetMapping(path = "form/books", produces = "text/html;charset=UTF-8")
    String showAllBooks(Model model) {

        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books", books);

        return "book/list";
    }

    // -- Edit book -- //
    @GetMapping(path = "form/edit", produces = "text/html;charset=UTF-8")
    String showEditForm(@RequestParam("id") int bookId, Model model) {
        Book book = bookService.findBookById(bookId);
        model.addAttribute("book", book);
        return "book/edit";
    }

    @PostMapping(path = "form/edit", produces = "text/html;charset=UTF-8")
    String processEditForm(Book book) {
        Book result = bookService.updateBook(book);
        return "redirect:/form/books";
    }

    // -- Remove book -- //
    @GetMapping(path = "form/remove", produces = "text/html;charset=UTF-8")
    String showRemovingConfirmation(Book book) {
        bookService.removeBook(book);
        return "redirect:/form/books";
    }

    @GetMapping(path = "form/find", produces = "text/html;charset=UTF-8")
    String showAllBooksByTitle(@RequestParam("title") String title, Model model) {

        List<Book> books = bookService.findAllBooksByTitle(title);

        model.addAttribute("books", books);

        return "book/list";
    }

    @GetMapping(path = "form/find1", produces = "text/html;charset=UTF-8")
    String showAllBooksByCategory(Category category, Model model) {

        List<Book> books = bookService.findAllBooksByCategory(category);

        model.addAttribute("books", books);

        return "book/list";
    }

    @GetMapping(path = "form/find2", produces = "text/html;charset=UTF-8")
    String showAllBooksByCategoryId(@RequestParam("id") long idCategory, Model model) {

        List<Book> books = bookService.findAllBooksByCategoryId(idCategory);

        model.addAttribute("books", books);

        return "book/list";
    }

    // zad 3a
    @GetMapping(path = "form/author", produces = "text/html;charset=UTF-8")
    String showAllBooksByAuthor(Author author, Model model) {

        List<Book> books = bookService.findAllBooksByAuthor(author);

        model.addAttribute("books", books);

        return "book/list";
    }

    // zad 3b
    @GetMapping(path = "form/publisher", produces = "text/html;charset=UTF-8")
    String showAllBooksByPublisher(Publisher publisher, Model model) {

        List<Book> books = bookService.findAllBooksByPublisher(publisher);

        model.addAttribute("books", books);

        return "book/list";
    }

    // zad 3c
    @GetMapping(path = "form/rating", produces = "text/html;charset=UTF-8")
    String showAllBooksByRating(@RequestParam("rating") int rating, Model model) {

        List<Book> books = bookService.findAllBooksByRating(rating);

        model.addAttribute("books", books);

        return "book/list";
    }

    // zad 3d
    @GetMapping(path = "form/category", produces = "text/html;charset=UTF-8")
    String showFirstBookByCategoryOrderByTitle(Category category, Model model) {

        Optional<Book> book = bookService.findFirstBookByCategoryOrderByTitle(category);

        model.addAttribute("books", List.of(book.orElseThrow(BookNotFoundException::new)));

        return "book/list";
    }

    @GetMapping(path = "form/ratingb", produces = "text/html;charset=UTF-8")
    String showAllBooksByRatingBetween(@RequestParam("start") int start, @RequestParam("stop") int stop, Model model) {

        List<Book> books = bookService.findAllBooksByRatingBetween(start, stop);

        model.addAttribute("books", books);

        return "book/list";
    }

    @ModelAttribute("publishers")
    Collection<Publisher> findAllPublishers() {
        return publisherService.findAllPublishers();
    }

    @ModelAttribute("authors")
    Collection<Author> findAllAuthors() {
        return authorService.findAllAuthors();
    }

    @ModelAttribute("categories")
    Collection<Category> findAllCategory() {
        return categoryService.findAllCategories();
    }
}
