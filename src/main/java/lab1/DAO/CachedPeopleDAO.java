package lab1.DAO;

import lab1.model.Person;

import java.util.HashMap;

public class CachedPeopleDAO implements PeopleDAO {
    private final HashMap<Integer, Person> cache = new HashMap<>();

    public CachedPeopleDAO() {
        super();
    }

    @Override
    public void save(Person person) {
        cache.put()
    }

}
