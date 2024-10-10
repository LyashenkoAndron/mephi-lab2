package lab1.DAO;

import lab1.model.Person;

import java.util.List;
import java.util.Optional;

public interface Dao {
    Person findById(int id);

    void save(Person person);

    public void update(int personId, Person person);

    void delete(int id);
}
