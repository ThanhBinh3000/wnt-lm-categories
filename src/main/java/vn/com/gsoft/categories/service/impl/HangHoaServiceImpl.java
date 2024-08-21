package vn.com.gsoft.categories.service.impl;


import lombok.extern.log4j.Log4j2;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.entity.*;
import vn.com.gsoft.categories.model.dto.HangHoaRep;
import vn.com.gsoft.categories.model.cache.HangHoaCache;
import vn.com.gsoft.categories.model.elastichsearch.HangHoaES;
import vn.com.gsoft.categories.model.system.Profile;
import vn.com.gsoft.categories.repository.*;
import vn.com.gsoft.categories.service.ESListService;
import vn.com.gsoft.categories.service.HangHoaService;
import vn.com.gsoft.categories.service.RedisListService;
import vn.com.gsoft.categories.util.system.DataUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Log4j2
public class HangHoaServiceImpl extends BaseServiceImpl<HangHoa, HangHoaRep, Long> implements HangHoaService {


    @Autowired
    private HangHoaRepository hdrRepo;
    @Autowired
    private RedisListService redisListService;
//    @Autowired
//    private HangHoaESRepository hangHoaESRepository;
    @Autowired
    private ESListService esListService;

    @Autowired
    public HangHoaServiceImpl(HangHoaRepository hdrRepo
                                ) {
        super(hdrRepo);
        this.hdrRepo = hdrRepo;
    }

    @Override
    public void pushProductData() {
        HangHoaRep rep = new HangHoaRep();
        var data = hdrRepo.searchListHangHoa();
        redisListService.pushProductDataRedis(DataUtils.convertList(data, HangHoaCache.class));
    }

    @Override
    public Page<HangHoa> getProductData(HangHoaRep req) {
//        var ids = new ArrayList<Long>();
//        ids.add(9738374L);
        Pageable pageable = PageRequest.of(req.getPaggingReq().getPage(), req.getPaggingReq().getLimit());
        Page<HangHoa> hangHoas = hdrRepo.searchPage(req, pageable);
        return hangHoas;
        //return redisListService.getHangHoaByIds(ids);
    }

    public void saveProduct() throws Exception{
        var req = new HangHoaRep();
        var list = hdrRepo.searchList(req);
        esListService.pushProductData(list);
    }
}
