package ol.kankan.kankan.dao;


import ol.kankan.kankan.dao.smalldto.SmallAccount;
import ol.kankan.kankan.entity.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccountDao {
    /**
     * 查询所有账户，并且获取每个账户所属的用户信息
     *
     * @return
     */
    @Select("select * from account")
    @Results(id = "accountMap", value = {
            @Result(id = true, column = "id", property = "id"), //true表示主键
            @Result(column = "uid", property = "uid"),
            @Result(column = "money", property = "money"),
            //user封装的类，用uid属性查找
            //fetchType:表示加载属性
            @Result(property = "user", column = "uid", one = @One(select = "ol.kankan.kankan.dao.UserDao.findSmallById", fetchType = FetchType.EAGER))
    })
    List<Account> findAll();

    /**
     * 根据uid查询详细账户
     *
     * @param id
     * @return
     */
    @Select("select * from account where id=#{id} ")
    @ResultMap("accountMap")
    Account findById(Integer id);

    /**
     * 根据uid查询详细账户
     *
     * @param uid
     * @return
     */
    @Select("select * from account  where uid=#{uid} ")
    @ResultMap("accountMap")
    Account findByUid(Integer uid);

    /**
     * 根据uid查询简单账户
     *
     * @param uid
     * @return
     */
    @Select("select id,money from account  where uid=#{uid} ")
    SmallAccount findSmallByUid(Integer uid);

}

