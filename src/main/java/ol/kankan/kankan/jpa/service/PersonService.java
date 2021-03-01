package ol.kankan.kankan.jpa.service;

import ol.kankan.kankan.jpa.entiry.Person;

/**
 * @author kankan
 * @version 1.0
 * @date 2021-02-28 22:46
 */
public interface PersonService {
    Person findById(long id);
}
