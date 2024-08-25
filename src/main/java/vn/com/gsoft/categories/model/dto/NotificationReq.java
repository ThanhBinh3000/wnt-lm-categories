package vn.com.gsoft.categories.model.dto;

import jakarta.persistence.Column;
import lombok.Data;
import vn.com.gsoft.categories.model.system.BaseRequest;

import java.util.Date;

@Data
public class NotificationReq extends BaseRequest {
    private String drugStoreId;
    private String title;
    private String link;
    private Integer notificationTypeID;
    private int status;
    private String contents;
    private int resourceID;
    private int storeId;
    private Date createDate;
}
