package ol.kankan.kankan.mybatis.dao.smalldto;

/**
 * @author kankan
 * @version 1.0
 * @created 2021-02-26 22:40 by kankan
 * @updated 2021-02-26 22:40 by kankan
 */
public class SmallAccount {
    private Integer id;
    private Integer uid;
    private Double money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
