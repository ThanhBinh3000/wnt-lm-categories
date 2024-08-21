package vn.com.gsoft.categories.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.NhomDuocLy;
import vn.com.gsoft.categories.entity.NhomNganhHang;
import vn.com.gsoft.categories.model.dto.NhomDuocLyReq;
import vn.com.gsoft.categories.model.dto.NhomNganhHangReq;

import java.util.List;

@Repository
public interface NhomDuocLyRepository extends BaseRepository<NhomDuocLy, NhomDuocLyReq, Long> {
  @Query("SELECT c FROM NhomDuocLy c " +
         "WHERE 1=1"
          + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id})"
          + " AND (:#{#param.nhomNganhHangId} IS NULL OR c.nhomNganhHangId = :#{#param.nhomNganhHangId})"
          + " AND (:#{#param.tenDuocLy} IS NULL OR lower(c.tenDuocLy) LIKE lower(concat('%',CONCAT(:#{#param.tenDuocLy},'%'))))"
          + " ORDER BY c.id desc"
  )
  Page<NhomDuocLy> searchPage(@Param("param") NhomDuocLyReq param, Pageable pageable);


  @Query("SELECT c FROM NhomDuocLy c " +
          "WHERE 1=1"
          + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
          + " AND (:#{#param.nhomNganhHangId} IS NULL OR c.nhomNganhHangId = :#{#param.nhomNganhHangId})"
          + " AND (:#{#param.tenDuocLy} IS NULL OR lower(c.tenDuocLy) LIKE lower(concat('%',CONCAT(:#{#param.tenDuocLy},'%'))))"
          + " ORDER BY c.id desc"
  )
  List<NhomDuocLy> searchList(@Param("param") NhomDuocLyReq param);

}
