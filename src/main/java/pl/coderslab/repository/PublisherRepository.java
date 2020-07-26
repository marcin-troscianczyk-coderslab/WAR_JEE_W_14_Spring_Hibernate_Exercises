package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PublisherRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Publisher addPublisher(String name) {

        Publisher publisher = new Publisher();
        publisher.setName(name);

        entityManager.persist(publisher);

        return publisher;
    }

    public Publisher updatePublisher(long publisherId, String newName) {

        Publisher publisher = entityManager.find(Publisher.class, publisherId);
        publisher.setName(newName);

        entityManager.merge(publisher);

        return publisher;
    }

    public Publisher findPublisherById(long id) {
        Publisher publisher = entityManager.find(Publisher.class, id);
        return publisher;
    }

    public Publisher removePublisher(long id) {
        Publisher publisher = entityManager.find(Publisher.class, id);
        if(publisher != null) {
            entityManager.remove(publisher);
        }

        return publisher;
    }
}
