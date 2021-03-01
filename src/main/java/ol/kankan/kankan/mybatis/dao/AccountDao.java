package ol.kankan.kankan.mybatis.dao;


import ol.kankan.kankan.mybatis.dao.smalldto.SmallAccount;
import ol.kankan.kankan.mybatis.entity.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface AccountDao {

    @Insert("insert into account (uid,money) values (#{uid},#{money})")
    /*useGeneratedKeys 允许JDBC支持自动生成主键，需要驱动兼容*/
    //keyProperty 放的是对象的属性，如果用@Param注解传递参，则要p.id选择属性，否则返回不了主键值
//    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    //@SelectKey注解也是一样
    // @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    Integer create(SmallAccount smallAccount);

    @Update("update account set uid=#{uid},money=#{money} where id=#{id}")
    Integer update(SmallAccount smallAccount);

    @Delete("delete from account where id=#{id}")
    Integer delete(@Param("id") Integer id);

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
            @Result(property = "user", column = "uid", one = @One(select = "ol.kankan.kankan.mybatis.dao.UserDao.findSmallById", fetchType = FetchType.EAGER))
    })
    List<Account> findAll();

    /**
     * 查询账户基本信息
     *
     * @return
     */
    @Select("select * from account")
    List<SmallAccount> findSmallAll();

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
     * 根据uid查询简单账户
     *
     * @param uid
     * @return
     */
    @Select("select * from account  where uid=#{uid} ")
    SmallAccount findSmallByUid(Integer uid);

    /**
     * 根据uid查询账户
     *
     * @param uid
     * @return
     */
    @Select("select * from account where uid=#{uid} ")
    List<Account> findByUid(Integer uid);

}

