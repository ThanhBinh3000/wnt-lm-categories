package vn.com.gsoft.categories.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.NhomNganhHang;
import vn.com.gsoft.categories.entity.NhomThuoc;
import vn.com.gsoft.categories.model.dto.NhomNganhHangReq;
import vn.com.gsoft.categories.model.dto.NhomThuocReq;

import java.util.List;

@Repository
public interface NhomNganhHangRepository extends BaseRepository<NhomNganhHang, NhomNganhHangReq, Long> {
  @Query("SELECT c FROM NhomNganhHang c " +
         "WHERE 1=1 "
          + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
          + " AND (:#{#param.tenNganhHang} IS NULL OR lower(c.tenNganhHang) LIKE lower(concat('%',CONCAT(:#{#param.tenNganhHang},'%'))))"
          + " ORDER BY c.id desc"
  )
  Page<NhomNganhHang> searchPage(@Param("param") NhomNganhHangReq param, Pageable pageable);


  @Query("SELECT c FROM NhomNganhHang c " +
          "WHERE 1=1 "
          + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
          + " AND (:#{#param.tenNganhHang} IS NULL OR lower(c.tenNganhHang) LIKE lower(concat('%',CONCAT(:#{#param.tenNganhHang},'%'))))"
          + " ORDER BY c.id desc"
  )
  List<NhomNganhHang> searchList(@Param("param") NhomNganhHangReq param);

}
