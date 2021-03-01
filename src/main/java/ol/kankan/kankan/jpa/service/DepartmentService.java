package ol.kankan.kankan.jpa.service;

import ol.kankan.kankan.jpa.entiry.Department;

/**
 * @author kankan
 * @version 1.0
 * @date 2021-02-28 22:46
 */
public interface DepartmentService {
    Department findById(long id);
}
