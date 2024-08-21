package vn.com.gsoft.categories.service;

import org.springframework.data.domain.Page;
import vn.com.gsoft.categories.entity.HangHoa;
import vn.com.gsoft.categories.model.dto.HangHoaRep;
import vn.com.gsoft.categories.model.cache.HangHoaCache;
import vn.com.gsoft.categories.model.elastichsearch.HangHoaES;

import java.util.List;

public interface HangHoaService extends BaseService<HangHoa, HangHoaRep, Long> {

    void pushProductData();

    Page<HangHoa> getProductData(HangHoaRep req);

    void saveProduct() throws Exception;
}