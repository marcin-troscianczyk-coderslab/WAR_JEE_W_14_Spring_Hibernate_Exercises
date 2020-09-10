package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Book addBook(String title, int rating, String description, Publisher publisher) {

        Book book = new Book();
        book.setTitle(title);
        book.setRating(rating);
        book.setDescription(description);

        // publisher
        entityManager.persist(publisher);
        book.setPublisher(publisher);

        // authors
        Author author1 = entityManager.find(Author.class, 1L);
        Author author2 = entityManager.find(Author.class, 2L);

        List<Author> authors = Arrays.asList(author1, author2);

        //book.setAuthors(authors);

        entityManager.persist(book);

        return book;
    }

    public Book addBook(Book book) {

        // publisher
        /*entityManager.persist(publisher);
        book.setPublisher(publisher);
        */

        entityManager.persist(book);

        return book;
    }

    public Book findBookById(long bookId) {

        Book book = entityManager.find(Book.class, bookId);

        return book;
    }

    public List<Book> findAllBooks() {
        Query allBooksQuery = entityManager.createQuery("select b from Book b");
        return allBooksQuery.getResultList();
    }

    public List<Book> getRatingList(int rating) {
        Query ratingListQuery = entityManager.createQuery("select b from Book b where b.rating = :rating");
        ratingListQuery.setParameter("rating", rating);
        return ratingListQuery.getResultList();
    }

    public List<Book> findAllBooksByPublisherIsNotNull() {
        Query allBooksByPublishersIsNotNullQuery =
                entityManager.createQuery("select b from Book b where b.publisher is not null");
        return allBooksByPublishersIsNotNullQuery.getResultList();
    }

    public List<Book> findAllBooksByPublisher(Publisher publisher) {
        Query allBooksByPublisherQuery =
                entityManager.createQuery("select b from Book b where b.publisher = :publisher");
        allBooksByPublisherQuery.setParameter("publisher", publisher);
        return allBooksByPublisherQuery.getResultList();
    }

    public List<Book> findAllBooksByAuthor(Author author) {
        Query allBooksByAuthorQuery =
                entityManager.createQuery("select b from Book b where :author member of b.authors");
        allBooksByAuthorQuery.setParameter("author", author);
        return allBooksByAuthorQuery.getResultList();
    }

    public Book updateBook(long bookId, String newTitle) {
        Book book = entityManager.find(Book.class, bookId);
        book.setTitle(newTitle);

        //return entityManager.merge(book);
        return book;
    }

    public Book updateBook(Book book) {
        return entityManager.merge(book);
    }

    public Book removeBook(long bookId) {
        Book book = entityManager.find(Book.class, bookId);
        entityManager.remove(book);

        return book;
    }

    public Book removeBook(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book));
        return book;
    }
}
