package ol.kankan.kankan.config.response;

import lombok.Data;

/**
 * @author kankan
 * @version 1.0
 * @created 2021-03-01 13:48 by kankan
 * @updated 2021-03-01 13:48 by kankan
 */
@Data
public final class ResultBuilder {
    private Object data;
    private short code;
    private boolean success;

    public ResultBuilder() {
    }

    public static ResultBuilder success(Object data) {
        return builders(ResultStatus.SUC, data);
    }

    public static ResultBuilder error(Object data) {
        return builders(ResultStatus.EEROR, data);
    }

    public static ResultBuilder builders(ResultStatus resultStatus, Object data) {
        ResultBuilder resultBuilder = new ResultBuilder();
        resultBuilder.setCode(resultStatus.getCode());
        resultBuilder.setSuccess(resultStatus.isSuccess());
        resultBuilder.setData(data);
        return resultBuilder;
    }

}
