package vn.com.gsoft.categories.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import vn.com.gsoft.categories.model.system.BaseRequest;

@EqualsAndHashCode(callSuper = false)
@Data
public class NhomNganhHangReq extends BaseRequest {
    private String tenNganhHang ;
}