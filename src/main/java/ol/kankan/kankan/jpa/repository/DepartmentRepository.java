package ol.kankan.kankan.jpa.repository;

import ol.kankan.kankan.jpa.entiry.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author kankan
 * @version 1.0
 * @date 2021-02-28 22:34
 */
public interface DepartmentRepository extends JpaRepository<Department, Long>, JpaSpecificationExecutor<Department> {

}
