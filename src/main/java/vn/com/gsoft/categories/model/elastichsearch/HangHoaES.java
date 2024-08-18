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
//@Document(indexName = "products")
public class HangHoaES {
    @Id
    private String id;
    //@Field(type = FieldType.Text)
    private String name;
}
