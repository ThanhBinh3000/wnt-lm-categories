package vn.com.gsoft.categories.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NhomThuocs")
public class NhomThuoc extends BaseEntity{
    @Id
    @Column(name = "MaNhomThuoc")
    private Long maNhomThuoc;
    @Column(name = "TenNhomThuoc")
    private String tenNhomThuoc;
    @Column(name = "MaNhaThuoc")
    private String maNhaThuoc;
}
