package ol.kankan.kankan.mybatis.entity;

import java.io.Serializable;

/**
 * @author kankan
 * @version 1.0
 * @created 2021-02-26 14:21 by kankan
 * @updated 2021-02-26 14:21 by kankan
 */
public class TestEntity implements Serializable {

    private Integer id ;

    private String magicId ;

    private String firstName ;

    private String lastName ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMagicId() {
        return magicId;
    }

    public void setMagicId(String magicId) {
        this.magicId = magicId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
