package ol.kankan.kankan.mybatis.dao;

import ol.kankan.kankan.mybatis.dao.smalldto.SmallUser;
import ol.kankan.kankan.mybatis.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户的持久层接口
 */
@Mapper
@Repository
public interface UserDao {

    @Insert("insert into user (username,birthday,sex,address) values (#{username},#{birthday},#{sex},#{address})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer create(SmallUser smallUser);

    @Update("update user set username=#{username},birthday=#{birthday},sex=#{sex},address=#{address} where id=#{id}")
    Integer update(SmallUser smallUser);

    @Delete("delete from user where id=#{id}")
    Integer delete(@Param("id") Integer id);
    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("select * from user")
    @Results(id = "userMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "address", property = "address"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "birthday", property = "birthday"),
            @Result(property = "accounts", column = "id",
                    many = @Many(select = "ol.kankan.kankan.mybatis.dao.AccountDao.findSmallByUid",
                            fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    /**
     * 查询所有用户基本信息
     * @return
     */
    @Select("select * from user")
    List<SmallUser> findSmallAll();

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    @Select("select * from user  where id=#{id} ")
    @ResultMap("userMap")
    User findById(Integer id);

    /**
     * 根据uid查询用户
     *
     * @param uid
     * @return
     */
    @Select("select * from user where id=#{uid}")
    SmallUser findSmallById(Integer uid);

}
