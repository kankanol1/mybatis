package ol.kankan.kankan.controller;

import ol.kankan.kankan.dao.UserDao;
import ol.kankan.kankan.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserDao userDao ;

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable Integer id){
        return userDao.findById(id);
    }

    @RequestMapping(value = "/get/list",method = RequestMethod.GET)
    public List<User>  findAll(){
        return userDao.findAll();
    }

}