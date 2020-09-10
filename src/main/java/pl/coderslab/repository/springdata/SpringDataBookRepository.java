package pl.coderslab.repository.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;

import java.util.List;
import java.util.Optional;

public interface SpringDataBookRepository extends JpaRepository<Book, Long> {

    //List<Book> findByTitle(String title);

    /*@Query("select b from Book b where b.title = ?1")
    List<Book> findByTitle(String title);*/

    @Query("select b from Book b where b.title = :title")
    List<Book> findByTitle(@Param("title") String title);

    /*@Query(value = "select * from books b where b.title = :title", nativeQuery = true)
    List<Book> findByTitle(@Param("title") String title);*/

    List<Book> findAllByCategory(Category category);

    List<Book> findAllBooksByCategoryId(long idCategory);

    // zad 3a
    List<Book> findAllBooksByAuthors(Author author);

    // zad 3b
    List<Book> findAllBooksByPublisher(Publisher publisher);

    // zad 3c
    List<Book> findAllBooksByRating(int rating);

    // zad 3d
    Optional<Book> findFirstBookByCategoryOrderByTitle(Category category);

    @Query("select b from Book b where b.rating between ?1 and ?2")
    List<Book> findAllBooksByRatingBetween(int start, int stop);
}
