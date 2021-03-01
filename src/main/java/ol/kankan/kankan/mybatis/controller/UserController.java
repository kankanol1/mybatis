package ol.kankan.kankan.mybatis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ol.kankan.kankan.mybatis.dao.UserDao;
import ol.kankan.kankan.mybatis.dao.smalldto.SmallUser;
import ol.kankan.kankan.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Api(tags = "MYBATIS: 用户管理")
public class UserController {

    @Autowired
    private UserDao userDao;

    @ApiOperation("添加账户")
    @PostMapping()
    public User create(@Validated @RequestBody SmallUser smallUser) {
        userDao.create(smallUser);
        return userDao.findById(smallUser.getId());
    }

    @ApiOperation("更新账户")
    @PutMapping()
    public User update(@Validated @RequestBody SmallUser smallUser) {
        userDao.update(smallUser);
        return userDao.findById(smallUser.getId());
    }

    @ApiOperation("删除账户")
    @DeleteMapping("{id}")
    public User delete(@PathVariable Integer id) {
        User user = userDao.findById(id);
        userDao.delete(id);
        return user;
    }

    @GetMapping("{id}")
    @ApiOperation("通过ID查找")
    public User findById(@PathVariable Integer id) {
        return userDao.findById(id);
    }

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    @ApiOperation("查找所有详细信息")
    public List<User> findAll() {
        return userDao.findAll();
    }

    @RequestMapping(value = "/get/small/list", method = RequestMethod.GET)
    @ApiOperation("查找所有基本信息")
    public List<SmallUser> findSmallAll() {
        return userDao.findSmallAll();
    }

}