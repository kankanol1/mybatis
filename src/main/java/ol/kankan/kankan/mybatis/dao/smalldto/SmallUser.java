package ol.kankan.kankan.mybatis.dao.smalldto;

import java.util.Date;

/**
 * @author kankan
 * @version 1.0
 * @created 2021-02-26 22:47 by kankan
 * @updated 2021-02-26 22:47 by kankan
 */
public class SmallUser {
    private Integer id;
    private String username;
    private String address;
    private String sex;
    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
