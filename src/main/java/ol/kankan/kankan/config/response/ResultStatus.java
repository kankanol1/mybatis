package ol.kankan.kankan.config.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author kankan
 * @version 1.0
 * @created 2021-03-01 13:45 by kankan
 * @updated 2021-03-01 13:45 by kankan
 */

public enum ResultStatus {
    SUC((short) 0,true),EEROR((short) -1,false);
    private short code;
    private boolean success;

    ResultStatus(short code, boolean success) {
        this.code = code;
        this.success = success;
    }

    public short getCode(){
        return code;
    }
    public boolean isSuccess() {
        return success;
    }
}
