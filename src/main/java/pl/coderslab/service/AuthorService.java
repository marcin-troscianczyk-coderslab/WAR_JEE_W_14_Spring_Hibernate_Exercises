package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.entity.Author;
import pl.coderslab.repository.AuthorRepository;

import javax.transaction.Transactional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    public Author addAuthor(String firstName, String lastName) {

        Author author = authorRepository.addAuthor(firstName, lastName);

        return author;
    }

    @Transactional
    public Author findAuthorById(long authorId) {
        return authorRepository.findAuthorById(authorId);
    }

    @Transactional
    public Author updateAuthor(long authorId, String newFirstName, String newLastName) {
        return authorRepository.updateAuthor(authorId, newFirstName, newLastName);
    }

    @Transactional
    public Author removeAuthor(long authorId) {
        return authorRepository.removeAuthor(authorId);
    }
}
