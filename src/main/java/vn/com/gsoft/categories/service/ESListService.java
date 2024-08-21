package vn.com.gsoft.categories.service;

import vn.com.gsoft.categories.entity.HangHoa;
import vn.com.gsoft.categories.model.cache.HangHoaCache;
import vn.com.gsoft.categories.model.elastichsearch.HangHoaES;

import java.util.List;

public interface ESListService {
   void pushProductData(List<HangHoa> data) throws Exception;
}
