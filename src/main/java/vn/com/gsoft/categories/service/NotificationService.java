package vn.com.gsoft.categories.service;


import vn.com.gsoft.categories.entity.NhomThuoc;
import vn.com.gsoft.categories.entity.Notification;
import vn.com.gsoft.categories.model.dto.NhomThuocReq;
import vn.com.gsoft.categories.model.dto.NotificationReq;

import java.util.List;

public interface NotificationService extends BaseService<Notification, NotificationReq, Long> {
    boolean updateStatus(List<Notification> items);
}