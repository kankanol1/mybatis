package ol.kankan.kankan.mybatis.entity;
import lombok.Getter;
import lombok.Setter;
import ol.kankan.kankan.mybatis.dao.smalldto.SmallUser;

import java.io.Serializable;

@Getter
@Setter
public class Account implements Serializable {

    private Integer id;
    private Integer uid;
    private String number;
    private Double money;

    //多对一（mybatis中称之为一对一）的映射：一个账户只能属于一个用户
    private SmallUser user;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", number=" + number +
                ", money=" + money +
                '}';
    }
}


