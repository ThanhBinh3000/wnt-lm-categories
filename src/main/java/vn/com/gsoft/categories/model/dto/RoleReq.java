package vn.com.gsoft.categories.model.dto;

import lombok.Data;
import vn.com.gsoft.categories.model.system.BaseRequest;
@Data
public class RoleReq extends BaseRequest {
    private String roleName;
    private Boolean isDeleted;
    private String maNhaThuoc;
    private String description;
    private Integer type;
}