package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PersonService;

@Controller
public class PersonController {

    private final PersonService personService;

    PersonController(final PersonService personService) {
        this.personService = personService;
    }

    // GET /person?id=1
    @GetMapping(path = "/person", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    String getPerson(@RequestParam("id") long personId) {

        Person person = personService.findPersonById(personId);

        return person.toString();
    }

    // POST /person login=admin&password=admin&email=admin@coderslab.pl
    @PostMapping(path = "/person", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    String addPerson(
            @RequestParam("login") String login,
            @RequestParam("password") String password,
            @RequestParam("email") String email) {

        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName("Jan");
        personDetails.setLastName("Kowalski");
        personDetails.setCity("Warszawa");
        personDetails.setStreet("Marszałkowska");
        personDetails.setStreetNumber((byte) 13);

        Person person = personService.addPerson(login, password, email, personDetails);

        return person.toString();

    }

    // PUT /person?id=1 password=admin123&email=admin123@coderslab.pl
    @PutMapping(path = "/person", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    String updatePerson(
            @RequestParam("id") long personId,
            @RequestParam("password") String newPassword,
            @RequestParam("email") String newEmail) {

        Person person = personService.updatePerson(personId, newPassword, newEmail);
        return person.toString();
    }

    // DELETE /person?id=1
    @DeleteMapping(path = "/person", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    String removePerson(@RequestParam("id") long personId) {

        Person person = personService.removePerson(personId);
        return person.toString();
    }

    // Formularze

    @GetMapping(path = "/form/person", produces = "text/html;charset=UTF-8")
    String showForm(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "person";
    }

    @PostMapping(path = "/form/person", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    String processForm(Person person) {

        Person result = personService.addPerson(person);

        return result.toString();
    }
}
