package ol.kankan.kankan.jpa.service.impl;

import lombok.RequiredArgsConstructor;
import ol.kankan.kankan.jpa.entiry.Department;
import ol.kankan.kankan.jpa.entiry.Person;
import ol.kankan.kankan.jpa.repository.DepartmentRepository;
import ol.kankan.kankan.jpa.service.DepartmentService;
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
@CacheConfig(cacheNames = "department")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private final DepartmentRepository departmentRepository;

    @Override
    public Department findById(long id) {
        Optional<Department> optional = departmentRepository.findById(id);
        if(optional!=null && optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public void create(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void update(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void delete(Department department) {
        departmentRepository.delete(department);
    }

    @Override
    public List<Department> findAll() {
        List<Department> departments = departmentRepository.findAll();
        return departments;
    }
}
