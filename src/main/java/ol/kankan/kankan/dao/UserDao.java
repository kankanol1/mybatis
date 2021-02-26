package ol.kankan.kankan.dao;

import ol.kankan.kankan.dao.smalldto.SmallUser;
import ol.kankan.kankan.entity.User;
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

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    @Results(id="userMap",value={
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "address",property = "address"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "birthday",property = "birthday"),
            @Result(property = "accounts",column = "id",
                    many = @Many(select = "ol.kankan.kankan.dao.AccountDao.findSmallByUid",
                            fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Select("select * from user  where id=#{id} ")
    @ResultMap("userMap")
    User findById(Integer id);
    /**
     * 根据uid查询用户
     * @param uid
     * @return
     */
    @Select("select * from user where id=#{uid}")
    SmallUser findSmallById(Integer uid);

}
