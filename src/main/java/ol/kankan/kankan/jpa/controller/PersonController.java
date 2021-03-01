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
import ol.kankan.kankan.mybatis.dao.smalldto.SmallAccount;
import ol.kankan.kankan.mybatis.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author kankan
 * @version 1.0
 * @created 2021-02-28 22:42 by kankan
 * @updated 2021-02-28 22:42 by kankan
 */
@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
@Api(tags = "JPA: 人员管理")
public class PersonController {
    @Autowired
    private PersonService personService;
    @Autowired
    private DepartmentService departmentService;

    @ApiOperation("添加人员")
    @PostMapping()
    public ResultBuilder create(@Validated @RequestBody SmallPerson smallPerson) {
        Person person = entity(smallPerson);
        personService.create(person);
        return ResultBuilder.success(person);
    }

    @ApiOperation("更新")
    @PutMapping()
    public ResultBuilder update(@Validated @RequestBody SmallPerson smallPerson) {
        Person person = entity(smallPerson);
        personService.update(person);
        return ResultBuilder.success(person);
    }

    @ApiOperation("删除")
    @DeleteMapping()
    public ResultBuilder delete(Long id) {
        Person person = personService.findById(id);
        if(null!=personService.findById(id)){
            personService.delete(person);
            return ResultBuilder.success(null);
        }else{
            return ResultBuilder.error(null);
        }
    }

    @GetMapping()
    @ApiOperation("通过ID查找")
    public ResultBuilder findById(Long id) {
        Person person = personService.findById(id);
        return ResultBuilder.success(null == person ? (new Array[0]) : person);
    }

    @GetMapping("/list")
    @ApiOperation("查找列表")
    public ResultBuilder findAll() {
        List<Person> person = personService.findAll();
        return ResultBuilder.success(null == person ? (new Array[0]) : person);
    }

    public Person entity(SmallPerson smallPerson) {
        String[] ids = smallPerson.getDepartment_id().split(",");
        Person person = new Person();
        Set<Department> departments = new LinkedHashSet<>();
        for (int i = 0; i < ids.length; i++) {
            departments.add(departmentService.findById(Long.valueOf(ids[i])));
        }
        person.setId(smallPerson.getId());
        person.setDepartments(departments);
        person.setName(smallPerson.getName());
        return person;
    }

}
