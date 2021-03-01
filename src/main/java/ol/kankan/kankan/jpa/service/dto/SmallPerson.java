package ol.kankan.kankan.jpa.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author kankan
 * @version 1.0
 * @created 2021-03-01 00:01 by kankan
 * @updated 2021-03-01 00:01 by kankan
 */
@Data
public class SmallPerson  implements Serializable {
    private long id;
    private String name;
    private String department_id;
}
