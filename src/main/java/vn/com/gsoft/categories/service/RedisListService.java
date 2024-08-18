package vn.com.gsoft.categories.service;

import vn.com.gsoft.categories.model.dto.HangHoaRep;
import vn.com.gsoft.categories.model.cache.HangHoaCache;

import java.text.ParseException;
import java.util.List;

public interface RedisListService {
   void pushProductDataRedis(List<HangHoaCache> hangHoas);

    List<HangHoaCache> getHangHoaByIds(List<Long> ids);
}
