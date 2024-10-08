package lab1.DAO;

import lab1.model.Person;

import java.util.List;
import java.util.Optional;

public interface Dao {
    Person findById(long id);

    void save(Person person);

    public Person update(int personId, Person person);

    void delete(int id);
}
