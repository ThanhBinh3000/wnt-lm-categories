package vn.com.gsoft.categories.model.elastichsearch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HangHoaES {
    @Id
    private String id;
    private String name;
}
