package ol.kankan.kankan.jpa.service.impl;

import lombok.RequiredArgsConstructor;
import ol.kankan.kankan.jpa.entiry.Person;
import ol.kankan.kankan.jpa.repository.PersonRepository;
import ol.kankan.kankan.jpa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author kankan
 * @version 1.0
 * @created 2021-02-28 22:48 by kankan
 * @updated 2021-02-28 22:48 by kankan
 */
@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "person")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private final PersonRepository personRepository;

    @Override
    public Person findById(long id) {
        Optional<Person> optional = personRepository.findById(id);
        if (optional != null && optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public void create(Person person) {
        personRepository.save(person);
    }

    @Override
    public void update(Person person) {
        personRepository.save(person);
    }

    @Override
    public void delete(Person person) {
        personRepository.delete(person);
    }

    @Override
    public List<Person> findAll() {
        List<Person> peoples = personRepository.findAll();
        return peoples;
    }
}
