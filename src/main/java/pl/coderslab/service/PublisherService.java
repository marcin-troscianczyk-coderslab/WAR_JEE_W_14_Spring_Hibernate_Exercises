package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.entity.Publisher;
import pl.coderslab.repository.PublisherRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Transactional
    public Publisher addPublisher(String name) {

        Publisher publisher = publisherRepository.addPublisher(name);

        return publisher;
    }

    @Transactional
    public Publisher findPublisherById(long publisherId) {
        return publisherRepository.findPublisherById(publisherId);
    }

    @Transactional
    public List<Publisher> findAllPublishers() {
        return publisherRepository.findAllPublishers();
    }

    @Transactional
    public Publisher updatePublisher(long publisherId, String newName) {
        return publisherRepository.updatePublisher(publisherId, newName);
    }

    @Transactional
    public Publisher removePublisher(long publisherId) {
        return publisherRepository.removePublisher(publisherId);
    }
}
