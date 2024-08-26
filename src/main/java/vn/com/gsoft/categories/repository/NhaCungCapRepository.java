package vn.com.gsoft.categories.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.NhaCungCaps;
import vn.com.gsoft.categories.entity.NhomThuoc;
import vn.com.gsoft.categories.model.dto.NhaCungCapReq;
import vn.com.gsoft.categories.model.dto.NhomThuocReq;

import java.util.List;

@Repository
public interface NhaCungCapRepository extends BaseRepository<NhaCungCaps, NhaCungCapReq, Long> {
  @Query("SELECT c FROM NhaCungCaps c " +
         "WHERE 1=1 "
          + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
          + " AND (:#{#param.maNhaThuoc} IS NULL OR c.maNhaThuoc = :#{#param.maNhaThuoc}) "
          + " AND (:#{#param.tenNhaCungCap} IS NULL OR lower(c.tenNhaCungCap) LIKE lower(concat('%',CONCAT(:#{#param.tenNhaCungCap},'%'))))"
          + " ORDER BY c.id desc"
  )
  Page<NhaCungCaps> searchPage(@Param("param") NhaCungCapReq param, Pageable pageable);


  @Query("SELECT c FROM NhaCungCaps c " +
          "WHERE 1=1 "
          + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
          + " AND (:#{#param.maNhaThuoc} IS NULL OR c.maNhaThuoc = :#{#param.maNhaThuoc}) "
          + " AND (:#{#param.tenNhaCungCap} IS NULL OR lower(c.tenNhaCungCap) LIKE lower(concat('%',CONCAT(:#{#param.tenNhaCungCap},'%'))))"
          + " ORDER BY c.id desc"
  )
  List<NhaCungCaps> searchList(@Param("param") NhaCungCapReq param);

}
