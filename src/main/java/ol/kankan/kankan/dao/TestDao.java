package ol.kankan.kankan.dao;

import ol.kankan.kankan.entity.TestEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TestDao {
    @Select("select * from test_entity where id=#{id}")
    TestEntity getById(Integer id);
}
