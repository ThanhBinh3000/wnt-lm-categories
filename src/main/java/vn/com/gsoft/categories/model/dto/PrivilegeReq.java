package vn.com.gsoft.categories.model.dto;

import lombok.Data;
import vn.com.gsoft.categories.model.system.BaseRequest;

@Data
public class PrivilegeReq extends BaseRequest {
    private String code;
    private String parentCode;
    private String name;
    private Boolean enable;
}
