package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;

@RestController
public class AuthorController {

    private final AuthorService authorService;

    AuthorController(final AuthorService authorService) {
        this.authorService = authorService;
    }

    // GET /author?id=1
    @GetMapping(path = "/author", produces = "text/plain;charset=UTF-8")
    String getAuthor(@RequestParam("id") long authorId) {

        Author author = authorService.findAuthorById(authorId);

        return  author.toString();
    }

    // POST /author firstNamet=Jan&lastName=Brzechwa
    @PostMapping(path = "/author", produces = "text/plain;charset=UTF-8")
    String addAuthor(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {

        Author author = authorService.addAuthor(firstName, lastName);

        return author.toString();

    }

    // PUT /author?id=1&firstName=Henryk&lastName=Sienkiewicz
    @PutMapping(path = "/author", produces = "text/plain;charset=UTF-8")
    String updateAuthor(
            @RequestParam("id") long authorId,
            @RequestParam("firstName") String newFirstName,
            @RequestParam("lastName") String newLastName) {

        Author author = authorService.updateAuthor(authorId, newFirstName, newLastName);
        return author.toString();
    }

    // DELETE /author?id=1
    @DeleteMapping(path = "/author", produces = "text/plain;charset=UTF-8")
    String removeAuthor(@RequestParam("id") long authorId) {

        Author author = authorService.removeAuthor(authorId);
        return author.toString();
    }
}
