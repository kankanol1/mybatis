package ol.kankan.kankan.controller;

import ol.kankan.kankan.dao.AccountDao;
import ol.kankan.kankan.entity.Account;
import ol.kankan.kankan.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountDao accountDao ;

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public Account findById(@PathVariable Integer id){
        return accountDao.findById(id);
    }

    @RequestMapping(value = "/get/uid/{uid}",method = RequestMethod.GET)
    public Account findByUid(@PathVariable Integer uid){
        return accountDao.findByUid(uid);
    }

    @RequestMapping(value = "/get/list",method = RequestMethod.GET)
    public List<Account>  findAll(){
        return accountDao.findAll();
    }



}