package vn.com.gsoft.categories.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.NhomThuoc;
import vn.com.gsoft.categories.model.dto.NhomThuocReq;

import java.util.List;

@Repository
public interface NhomThuocRepository extends BaseRepository<NhomThuoc, NhomThuocReq, Long> {
  @Query("SELECT c FROM NhomThuoc c " +
         "WHERE 1=1 "
          + " AND (:#{#param.id} IS NULL OR c.maNhomThuoc = :#{#param.id}) "
          + " AND (:#{#param.maNhaThuoc} IS NULL OR c.maNhaThuoc = :#{#param.maNhaThuoc}) "
          + " AND (:#{#param.tenNhomThuoc} IS NULL OR lower(c.tenNhomThuoc) LIKE lower(concat('%',CONCAT(:#{#param.tenNhomThuoc},'%'))))"
          + " ORDER BY c.maNhomThuoc desc"
  )
  Page<NhomThuoc> searchPage(@Param("param") NhomThuocReq param, Pageable pageable);


  @Query("SELECT c FROM NhomThuoc c " +
          "WHERE 1=1 "
          + " AND (:#{#param.id} IS NULL OR c.maNhomThuoc = :#{#param.id}) "
          + " AND (:#{#param.maNhaThuoc} IS NULL OR c.maNhaThuoc = :#{#param.maNhaThuoc}) "
          + " AND (:#{#param.tenNhomThuoc} IS NULL OR lower(c.tenNhomThuoc) LIKE lower(concat('%',CONCAT(:#{#param.tenNhomThuoc},'%'))))"
          + " ORDER BY c.maNhomThuoc desc"
  )
  List<NhomThuoc> searchList(@Param("param") NhomThuocReq param);

}
