package ol.kankan.kankan.jpa.service;

import ol.kankan.kankan.jpa.entiry.Person;

import java.util.List;

/**
 * @author kankan
 * @version 1.0
 * @date 2021-02-28 22:46
 */
public interface PersonService {
    Person findById(long id);

    List<Person> findAll();

    void create(Person person);

    void update(Person person);

    void delete(Person person);
}
