package ol.kankan.kankan.mybatis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ol.kankan.kankan.mybatis.dao.AccountDao;
import ol.kankan.kankan.mybatis.dao.smalldto.SmallAccount;
import ol.kankan.kankan.mybatis.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
@Api(tags = "MYBATIS: 账号管理")
public class AccountController {

    @Autowired
    private AccountDao accountDao ;

    @ApiOperation("添加账户")
    @PostMapping()
    public Account create(@Validated @RequestBody SmallAccount smallAccount){
        accountDao.create(smallAccount);
        return accountDao.findById(smallAccount.getId());
    }
    @ApiOperation("更新账户")
    @PutMapping()
    public Account update(@Validated @RequestBody SmallAccount smallAccount){
        accountDao.update(smallAccount);
        return accountDao.findById(smallAccount.getId());
    }

    @ApiOperation("删除账户")
    @DeleteMapping("/{id}")
    public Account delete(@PathVariable Integer id){
        Account account = accountDao.findById(id);
        accountDao.delete(id);
        return account;
    }

    @GetMapping("/{id}")
    @ApiOperation("通过账户ID查找")
    public Account findById(@PathVariable Integer id){
        return accountDao.findById(id);
    }

    @RequestMapping(value = "/uid/{uid}",method = RequestMethod.GET)
    @ApiOperation("通过账户UiD查找")
    public List<Account> findByUid(@PathVariable Integer uid){
        return accountDao.findByUid(uid);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ApiOperation("查找所有账户详细信息")
    public List<Account>  findAll(){
        return accountDao.findAll();
    }

    @RequestMapping(value = "/small/list",method = RequestMethod.GET)
    @ApiOperation("查找所有账户基本信息")
    public List<SmallAccount>  findSmallAll(){
        return accountDao.findSmallAll();
    }
}