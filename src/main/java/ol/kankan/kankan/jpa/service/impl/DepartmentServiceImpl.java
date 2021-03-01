package ol.kankan.kankan.jpa.service.impl;

import lombok.RequiredArgsConstructor;
import ol.kankan.kankan.jpa.entiry.Department;
import ol.kankan.kankan.jpa.repository.DepartmentRepository;
import ol.kankan.kankan.jpa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

/**
 * @author kankan
 * @version 1.0
 * @created 2021-02-28 22:48 by kankan
 * @updated 2021-02-28 22:48 by kankan
 */
@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "department")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private final DepartmentRepository departmentRepository;

    @Override
    public Department findById(long id) {
        return departmentRepository.findById(id).get();
    }
}
