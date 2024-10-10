package lab1.Service;

import lab1.DAO.Dao;
import lab1.model.Person;

public class PeopleService {
    private final Dao dao;

    public PeopleService(Dao dao) {
        this.dao = dao;
    }

    public void savePerson(Person person) {
        dao.save(person);
    }

    public void deletePerson(int id) {
        dao.delete(id);
    }

    public Person getPersonById(int id) {
        return dao.findById(id);
    }

    public void updatePerson(int id, Person person) {
        dao.update(id, person);
    }
}
