package vn.com.gsoft.categories.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.NhomDuocLy;
import vn.com.gsoft.categories.entity.NhomHoatChat;
import vn.com.gsoft.categories.model.dto.NhomDuocLyReq;
import vn.com.gsoft.categories.model.dto.NhomHoatChatReq;

import java.util.List;

@Repository
public interface NhomHoatChatRepository extends BaseRepository<NhomHoatChat, NhomHoatChatReq, Long> {
  @Query("SELECT c FROM NhomHoatChat c " +
         "WHERE 1=1"
          + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id})"
          + " AND (:#{#param.nhomDuocLyId} IS NULL OR c.nhomDuocLyId = :#{#param.nhomDuocLyId})"
          + " AND (:#{#param.tenHoatChat} IS NULL OR lower(c.tenHoatChat) LIKE lower(concat('%',CONCAT(:#{#param.tenHoatChat},'%'))))"
          + " ORDER BY c.id desc"
  )
  Page<NhomHoatChat> searchPage(@Param("param") NhomHoatChatReq param, Pageable pageable);


  @Query("SELECT c FROM NhomHoatChat c " +
          "WHERE 1=1"
          + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
          + " AND (:#{#param.nhomDuocLyId} IS NULL OR c.nhomDuocLyId = :#{#param.nhomDuocLyId})"
          + " AND (:#{#param.tenHoatChat} IS NULL OR lower(c.tenHoatChat) LIKE lower(concat('%',CONCAT(:#{#param.tenHoatChat},'%'))))"
          + " ORDER BY c.id desc"
  )
  List<NhomHoatChat> searchList(@Param("param") NhomHoatChatReq param);

}
