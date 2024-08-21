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
@Table(name = "NhomDuocLy")
public class NhomDuocLy extends BaseEntity{
    @Id
    @Column(name = "Id")
    private Long id;
    @Column(name = "TenDuocLy")
    private String tenDuocLy;
    @Column(name = "NhomNganhHangId")
    private Integer nhomNganhHangId;
}
