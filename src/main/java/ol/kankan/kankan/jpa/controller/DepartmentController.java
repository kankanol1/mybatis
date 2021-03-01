package ol.kankan.kankan.jpa.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import ol.kankan.kankan.jpa.entiry.Department;
import ol.kankan.kankan.jpa.entiry.Person;
import ol.kankan.kankan.jpa.service.DepartmentService;
import ol.kankan.kankan.jpa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("{id}")
    @ApiOperation("通过ID查找")
    public Department findById(@PathVariable Long id) {
        return departmentService.findById(id);
    }


}
