package ol.kankan.kankan.entity;

/**
 * @author kankan
 * @version 1.0
 * @created 2021-02-26 15:44 by kankan
 * @updated 2021-02-26 15:44 by kankan
 */
public class BankCard {
    private Integer id ;
    private String accountNumber ;
    private String accountName ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
