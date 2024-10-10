package lab1.DAO;

import lab1.model.Person;

import java.util.HashMap;

public class CachedPeopleDAO implements Dao {
    private final HashMap<Integer, Person> cache = new HashMap<>();

    @Override
    public Person findById(int id) {
        return cache.get(id);
    }

    @Override
    public void save(Person person) {
        cache.put(person.getId(), person);
    }

    @Override
    public void update(int personId, Person person) {
        cache.put(personId, person);
    }

    @Override
    public void delete(int id) {
        cache.remove(id);
    }
}
