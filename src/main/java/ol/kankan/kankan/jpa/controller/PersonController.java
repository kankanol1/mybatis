package ol.kankan.kankan.jpa.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import ol.kankan.kankan.jpa.entiry.Person;
import ol.kankan.kankan.jpa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

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

    @GetMapping("{id}")
    @ApiOperation("通过ID查找")
    public Person findById(@PathVariable Long id) {
        return personService.findById(id);
    }


}
