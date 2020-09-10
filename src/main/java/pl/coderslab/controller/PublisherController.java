package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.PublisherService;

@RestController
public class PublisherController {

    private final PublisherService publisherService;

    PublisherController(final PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    // GET /publisher?id=1
    @GetMapping(path = "/publisher", produces = "text/plain;charset=UTF-8")
    String getPublisher(@RequestParam("id") long publisherId) {

        Publisher publisher = publisherService.findPublisherById(publisherId);

        return publisher.toString();
    }

    // POST /publisher name=Atena
    @PostMapping(path = "/publisher", produces = "text/plain;charset=UTF-8")
    String addPublisher(
            @RequestParam("name") String name) {

        Publisher publisher = publisherService.addPublisher(name);

        return publisher.toString();

    }

    // PUT /publisher?id=1&name=Prószynski i S-ka
    @PutMapping(path = "/publisher", produces = "text/plain;charset=UTF-8")
    String updatePublisher(
            @RequestParam("id") long publisherId,
            @RequestParam("name") String newName) {

        Publisher publisher = publisherService.updatePublisher(publisherId, newName);
        return publisher.toString();
    }

    // DELETE /publisher?id=1
    @DeleteMapping(path = "/publisher", produces = "text/plain;charset=UTF-8")
    String removePublisher(@RequestParam("id") long publisherId) {

        Publisher publisher = publisherService.removePublisher(publisherId);
        return publisher.toString();
    }
}
