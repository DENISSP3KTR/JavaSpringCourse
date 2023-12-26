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
}
