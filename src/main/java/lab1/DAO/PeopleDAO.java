package lab1.DAO;

import com.fasterxml.jackson.databind.ObjectMapper;
import lab1.model.Person;

import java.io.File;
import java.io.IOException;

public class PeopleDAO implements Dao {
    private final File personDir = new File("data");
    private final ObjectMapper objectMapper = new ObjectMapper();
    //private int currentId;

    /*private int getMaxId() {
        File[] files = personDir.listFiles();
        int maxId = 0;

        if (files != null) {
            for (File file : files) {
                try {
                    String name = file.getName().replace(".json", "");
                    int id = Integer.parseInt(name);
                    if (id > maxId) {
                        maxId = id;
                    }
                }
                catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }

        return maxId + 1;
    }*/

    public PeopleDAO() {
        if (!personDir.exists()) {
            personDir.mkdir();
        }
        //currentId = getMaxId();
    }

    public Person findById(long id) {
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

    public Person update(int personId, Person person) {
        File file = new File(personDir, personId + ".json");
        try {
            if (file.exists()) {
                Person existingPerson = objectMapper.readValue(file, Person.class);

                existingPerson.setFullName(person.getFullName());
                existingPerson.setBirth_year(person.getBirthYear());
                existingPerson.setPhone_number(person.getPhoneNumber());

                objectMapper.writeValue(file, existingPerson);
                return existingPerson;
            } else {
                throw new IOException("Person not found for ID: " + personId);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public void delete(int id) {
        File file = new File(personDir, id + ".json");
        if (file.exists()) {
            file.delete();
        }
    }
}
