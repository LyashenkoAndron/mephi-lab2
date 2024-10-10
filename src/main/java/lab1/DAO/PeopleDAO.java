package lab1.DAO;

import com.fasterxml.jackson.databind.ObjectMapper;
import lab1.model.Person;

import java.io.File;
import java.io.IOException;

public class PeopleDAO implements Dao {
    private final File personDir = new File("data");
    private final ObjectMapper objectMapper = new ObjectMapper();

    public PeopleDAO() {
        if (!personDir.exists()) {
            personDir.mkdir();
        }
    }

    public Person findById(int id) {
        try {
            File file = new File(personDir, id + ".json");
            if (file.exists()) {
                return objectMapper.readValue(file, Person.class);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void save(Person person) {
        try {
            File file = new File(personDir, person.getId() + ".json");
            objectMapper.writeValue(file, person);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(int personId, Person person) {
        File file = new File(personDir, personId + ".json");
        try {
            if (file.exists()) {
                person.setId(personId);
                objectMapper.writeValue(file, person);
            } else {
                throw new IOException("Person not found for ID: " + personId);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void delete(int id) {
        File file = new File(personDir, id + ".json");
        if (file.exists()) {
            file.delete();
        }
    }
}
