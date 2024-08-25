package vn.com.gsoft.categories.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.NhomThuoc;
import vn.com.gsoft.categories.entity.Notification;
import vn.com.gsoft.categories.model.dto.NhomThuocReq;
import vn.com.gsoft.categories.model.dto.NotificationReq;

import java.util.List;

@Repository
public interface NotificationRepository extends BaseRepository<Notification, NotificationReq, Long> {
  @Query("SELECT c FROM Notification c " +
         "WHERE 1=1 "
          + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
          + " AND (:#{#param.drugStoreId} IS NULL OR c.drugStoreId = :#{#param.drugStoreId}) "
          + " AND (:#{#param.notificationTypeID} IS NULL OR c.notificationTypeID = :#{#param.notificationTypeID}) "
          + " ORDER BY c.createDate desc"
  )
  Page<Notification> searchPage(@Param("param") NotificationReq param, Pageable pageable);


  @Query("SELECT c FROM Notification c " +
          "WHERE 1=1 "
          + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
          + " AND (:#{#param.drugStoreId} IS NULL OR c.drugStoreId = :#{#param.drugStoreId}) "
          + " AND (:#{#param.notificationTypeID} IS NULL OR c.notificationTypeID = :#{#param.notificationTypeID}) "
          + " ORDER BY c.createDate desc"
  )
  List<Notification> searchList(@Param("param") NotificationReq param);

}
