package ol.kankan.kankan.mybatis.controller;

import ol.kankan.kankan.mybatis.dao.TestDao;
import ol.kankan.kankan.mybatis.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private TestDao testDao ;

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public TestEntity test(@PathVariable Integer id){
        return testDao.getById(id);
    }

}