package vn.com.gsoft.categories.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.com.gsoft.categories.model.cache.HangHoaCache;
import vn.com.gsoft.categories.model.dto.HangHoaRep;
import vn.com.gsoft.categories.service.HangHoaService;
import vn.com.gsoft.categories.service.RedisListService;

import java.util.List;

@SpringBootTest
@Slf4j
class PushDataRedis {
    @Autowired
    private HangHoaService hangHoaService;
    private RedisListService redisListService;
    @Test
    void pushProductData() throws Exception {
        //HangHoaRep rep = new HangHoaRep();
        //rep.setTenThuoc("ginseng");
        //List<HangHoaCache> hh = hangHoaService.getProductData(rep);
        //hangHoaService.pushProductData();
    }
}