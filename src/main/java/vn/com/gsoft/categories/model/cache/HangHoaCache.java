package vn.com.gsoft.categories.model.cache;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HangHoaCache {
    private Integer thuocId;
    private String tenThuoc;
    private String tenNhomThuoc;
    private String tenDonVi;
}
