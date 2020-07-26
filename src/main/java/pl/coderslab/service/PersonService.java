package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;
import pl.coderslab.repository.AuthorRepository;
import pl.coderslab.repository.PersonRepository;

import javax.transaction.Transactional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public Person addPerson(String login, String password, String email, PersonDetails personDetails) {

        Person person = personRepository.addPerson(login, password, email, personDetails);

        return person;
    }

    @Transactional
    public Person addPerson(Person person) {

        Person result = personRepository.addPerson(person);

        return result;
    }

    @Transactional
    public Person findPersonById(long personId) {
        return personRepository.findPersonById(personId);
    }

    @Transactional
    public Person updatePerson(long personId, String newPassword, String newEmail) {
        return personRepository.updatePerson(personId, newPassword, newEmail);
    }

    @Transactional
    public Person removePerson(long personId) {
        return personRepository.removePerson(personId);
    }
}
