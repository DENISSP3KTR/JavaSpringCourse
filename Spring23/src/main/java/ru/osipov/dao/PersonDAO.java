package ru.osipov.dao;

import org.springframework.stereotype.Component;
import ru.osipov.models.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static int pc;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++pc,"Tom"));
        people.add(new Person(++pc, "Billy"));
        people.add(new Person(++pc, "Bart"));
        people.add(new Person(++pc, "Lisa"));

    }

    public List<Person> index() {
        return people;
    }
    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++pc);
        people.add(person);
    }

    public void update(int id, Person updatePerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatePerson.getName());
    }
    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
