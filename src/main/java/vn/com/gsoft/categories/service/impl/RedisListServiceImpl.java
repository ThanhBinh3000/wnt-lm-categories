package vn.com.gsoft.categories.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.constant.CachingConstant;
import vn.com.gsoft.categories.model.dto.*;
import vn.com.gsoft.categories.model.cache.HangHoaCache;
import vn.com.gsoft.categories.service.RedisListService;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RedisListServiceImpl implements RedisListService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void pushProductDataRedis(List<HangHoaCache> hangHoas) {
           hangHoas.forEach(this::saveProductToRedis);
    }

    public List<HangHoaCache> getHangHoaByIds(List<Long> ids) {
        return ids.stream()
                .map(id -> {
                    Map<Object, Object> entries = redisTemplate.opsForHash().entries(CachingConstant.HANG_HOA + ":" + id);
                    return objectMapper.convertValue(entries, HangHoaCache.class);
                })
                .collect(Collectors.toList());
    }

    private void saveProductToRedis(HangHoaCache data) {
        String key = CachingConstant.HANG_HOA + ":" + data.getThuocId();
        redisTemplate.opsForHash().putAll(key, objectMapper.convertValue(data, Map.class));
    }
}
