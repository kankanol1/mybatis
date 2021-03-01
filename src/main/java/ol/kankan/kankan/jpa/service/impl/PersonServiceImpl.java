package ol.kankan.kankan.jpa.service.impl;

import lombok.RequiredArgsConstructor;
import ol.kankan.kankan.jpa.entiry.Person;
import ol.kankan.kankan.jpa.repository.PersonRepository;
import ol.kankan.kankan.jpa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return personRepository.findById(id).get();
    }
}
