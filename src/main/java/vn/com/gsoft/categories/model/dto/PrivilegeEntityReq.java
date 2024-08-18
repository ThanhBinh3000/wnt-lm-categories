package vn.com.gsoft.categories.model.dto;

import lombok.Data;
import vn.com.gsoft.categories.model.system.BaseRequest;

@Data
public class PrivilegeEntityReq extends BaseRequest {
    private Long privilegeId;
    private Long entityId;
}
