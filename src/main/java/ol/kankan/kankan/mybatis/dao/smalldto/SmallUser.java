package ol.kankan.kankan.mybatis.dao.smalldto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author kankan
 * @version 1.0
 * @created 2021-02-26 22:47 by kankan
 * @updated 2021-02-26 22:47 by kankan
 */
@Setter
@Getter
public class SmallUser {
    private Integer id;
    private String username;
    private String address;
    private String sex;
    private Date birthday;
}
