package lab1.DAO;

import lab1.model.Person;

import java.util.HashMap;

public class CachedPeopleDAO implements Dao {
    private final HashMap<Integer, Person> cache = new HashMap<>();

    public Person findById(int id) {
        return cache.get(id);
    }

    public void save(Person person) {
        cache.put(person.getId(), person);
    }

    public void update(int personId, Person person) {
        cache.put(personId, person);
    }

    public void delete(int id) {
        cache.remove(id);
    }
}
