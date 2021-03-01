package ol.kankan.kankan.jpa.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import ol.kankan.kankan.config.response.ResultBuilder;
import ol.kankan.kankan.jpa.entiry.Department;
import ol.kankan.kankan.jpa.entiry.Person;
import ol.kankan.kankan.jpa.service.DepartmentService;
import ol.kankan.kankan.jpa.service.PersonService;
import ol.kankan.kankan.jpa.service.dto.SmallDepartment;
import ol.kankan.kankan.jpa.service.dto.SmallPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author kankan
 * @version 1.0
 * @created 2021-02-28 22:42 by kankan
 * @updated 2021-02-28 22:42 by kankan
 */
@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
@Api(tags = "JPA: 部门管理")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private PersonService personService;

    @ApiOperation("添加")
    @PostMapping()
    public ResultBuilder create(@Validated @RequestBody SmallDepartment smallDepartment) {
        Department department = entity(smallDepartment);
        departmentService.create(department);
        return ResultBuilder.success(department);
    }

    @ApiOperation("更新")
    @PutMapping()
    public ResultBuilder update(@Validated @RequestBody SmallDepartment smallDepartment) {
        Department department = entity(smallDepartment);
        departmentService.update(department);
        return ResultBuilder.success(department);
    }

    @ApiOperation("删除")
    @DeleteMapping()
    public ResultBuilder delete(Long id) {
        Department department = departmentService.findById(id);
        if (null != departmentService.findById(id)) {
            departmentService.delete(department);
            return ResultBuilder.success(null);
        } else {
            return ResultBuilder.error(null);
        }
    }

    @GetMapping()
    @ApiOperation("通过ID查找")
    public ResultBuilder findById(Long id) {
        Department department = departmentService.findById(id);
        return ResultBuilder.success(null == department ? (new Array[0]) : department);
    }

    @GetMapping("/list")
    @ApiOperation("查找列表")
    public ResultBuilder findAll() {
        List<Department> departments = departmentService.findAll();
        return ResultBuilder.success(null == departments ? (new Array[0]) : departments);
    }

    public Department entity(SmallDepartment smallDepartment) {
        String[] ids = smallDepartment.getPerson_id().split(",");
        Department department = new Department();
        Set<Person> persons = new LinkedHashSet<>();
        for (int i = 0; i < ids.length; i++) {
            persons.add(personService.findById(Long.valueOf(ids[i])));
        }
        department.setId(smallDepartment.getId());
        department.setPersons(persons);
        department.setName(smallDepartment.getName());
        return department;
    }
}
