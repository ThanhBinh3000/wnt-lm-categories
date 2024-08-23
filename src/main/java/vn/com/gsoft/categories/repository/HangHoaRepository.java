package vn.com.gsoft.categories.repository;

import jakarta.persistence.Tuple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.Thuocs;
import vn.com.gsoft.categories.model.dto.HangHoaRep;

import java.util.List;

@Repository
public interface HangHoaRepository extends BaseRepository<Thuocs, HangHoaRep, Long> {
    @Query(value = "SELECT * FROM Thuocs c "
            + "WHERE 1=1 "
            + " AND ((:#{#param.thuocId} IS NULL) OR (c.ThuocId = :#{#param.thuocId}))"
            + " AND ((:#{#param.maNhaThuoc} IS NULL) OR (c.NhaThuoc_MaNhaThuoc = :#{#param.maNhaThuoc}))"
            + " AND ((:#{#param.recordStatusId} IS NULL) OR (c.RecordStatusId = :#{#param.recordStatusId}))"
            + " AND (:#{#param.tenThuoc} IS NULL OR lower(c.TenThuoc) LIKE lower(concat('%',CONCAT(:#{#param.tenThuoc},'%'))))"
            + " AND (:#{#param.nhomThuocId} IS NULL OR c.nhomThuoc_MaNhomThuoc = :#{#param.nhomThuocId})"
            + " AND (:#{#param.nhomDuocLyId} IS NULL OR c.NhomDuocLyId = :#{#param.nhomDuocLyId})"
            + " AND (:#{#param.nhomHoatChatId} IS NULL OR c.NhomHoatChatId = :#{#param.nhomHoatChatId})"
            + " AND (:#{#param.nhomNganhHangId} IS NULL OR c.NhomNganhHangId = :#{#param.nhomNganhHangId})"
            + " AND (:#{#param.hangThayTheId} IS NULL OR c.NhomHoatChatId in (SELECT c1.NhomHoatChatId FROM Thuocs c1 WHERE c1.ThuocId = :#{#param.hangThayTheId}))"
            + " ORDER BY c.TenThuoc", nativeQuery = true
    )
    Page<Thuocs> searchPage(@Param("param") HangHoaRep param, Pageable pageable);

    @Query(value = "SELECT * FROM Thuocs c "
            + "WHERE 1=1 "
            + " AND ((:#{#param.thuocId} IS NULL) OR (c.ThuocId = :#{#param.thuocId}))"
            + " AND ((:#{#param.maNhaThuoc} IS NULL) OR (c.NhaThuoc_MaNhaThuoc = :#{#param.maNhaThuoc}))"
            + " AND ((:#{#param.recordStatusId} IS NULL) OR (c.RecordStatusId = :#{#param.recordStatusId}))"
            + " AND (:#{#param.tenThuoc} IS NULL OR lower(c.TenThuoc) LIKE lower(concat('%',CONCAT(:#{#param.tenThuoc},'%'))))"
            + " AND (:#{#param.nhomThuocId} IS NULL OR c.nhomThuoc_MaNhomThuoc = :#{#param.nhomThuocId})"
            + " AND (:#{#param.nhomDuocLyId} IS NULL OR c.NhomDuocLyId = :#{#param.nhomDuocLyId})"
            + " AND (:#{#param.nhomHoatChatId} IS NULL OR c.NhomHoatChatId = :#{#param.nhomHoatChatId})"
            + " AND (:#{#param.nhomNganhHangId} IS NULL OR c.NhomNganhHangId = :#{#param.nhomNganhHangId})"
            + " AND (:#{#param.hangThayTheId} IS NULL OR c.NhomHoatChatId in (SELECT c1.NhomHoatChatId FROM Thuocs c1 WHERE c1.ThuocId = :#{#param.hangThayTheId}))"
            + " ORDER BY c.TenThuoc", nativeQuery = true
    )
    List<Thuocs> searchList(@Param("param") HangHoaRep param);

    @Query(value = "SELECT c.ThuocId as thuocId," +
            " c.TenThuoc AS tenThuoc," +
            " c.TenDonVi AS tenDonVi," +
            " c.tenNhomThuoc AS tenNhomThuoc  FROM HangHoa c "
            + "WHERE 1=1 ", nativeQuery = true
    )
    List<Tuple> searchListHangHoa();

    Thuocs findByThuocId(long l);
}
