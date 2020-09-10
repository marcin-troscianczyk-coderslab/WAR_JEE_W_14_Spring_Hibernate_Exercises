package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Person addPerson(String login, String password, String email, PersonDetails personDetails) {

        Person person = new Person();
        person.setLogin(login);
        person.setPassword(password);
        person.setEmail(email);

        //entityManager.persist(personDetails);
        person.setPersonDetails(personDetails);

        entityManager.persist(person);

        return person;
    }

    public Person addPerson(Person person) {

        PersonDetails personDetails = person.getPersonDetails();
        entityManager.persist(personDetails);
        entityManager.persist(person);

        return person;
    }

    public Person updatePerson(long personId, String newPassword, String newEmail) {

        Person person = entityManager.find(Person.class, personId);
        person.setPassword(newPassword);
        person.setEmail(newEmail);
        return entityManager.merge(person);
    }

    public Person findPersonById(long id) {
        Person person = entityManager.find(Person.class, id);
        return person;
    }

    public Person removePerson(long id) {
        Person person = entityManager.find(Person.class, id);
        if (person != null) {
            entityManager.remove(person);
        }

        return person;
    }
}
