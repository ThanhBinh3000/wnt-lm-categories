package vn.com.gsoft.categories.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import vn.com.gsoft.categories.model.system.BaseRequest;

@EqualsAndHashCode(callSuper = false)
@Data
public class NhomHoatChatReq extends BaseRequest {
    private String tenHoatChat ;
    private Integer nhomDuocLyId;
}
