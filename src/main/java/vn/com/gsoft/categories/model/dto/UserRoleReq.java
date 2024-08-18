package vn.com.gsoft.categories.model.dto;

import lombok.Data;
import vn.com.gsoft.categories.model.system.BaseRequest;

@Data
public class UserRoleReq extends BaseRequest {
    private Long roleId;
    private Long userId;
}
