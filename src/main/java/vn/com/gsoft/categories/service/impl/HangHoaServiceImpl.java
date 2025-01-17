package vn.com.gsoft.categories.service.impl;


import lombok.extern.log4j.Log4j2;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.constant.RecordStatusContains;
import vn.com.gsoft.categories.entity.*;
import vn.com.gsoft.categories.model.dto.HangHoaRep;
import vn.com.gsoft.categories.model.cache.HangHoaCache;
import vn.com.gsoft.categories.model.elastichsearch.HangHoaES;
import vn.com.gsoft.categories.model.system.PaggingReq;
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
public class HangHoaServiceImpl extends BaseServiceImpl<Thuocs, HangHoaRep, Long> implements HangHoaService {


    @Autowired
    private HangHoaRepository hdrRepo;
    @Autowired
    private RedisListService redisListService;
    @Autowired
    private ESListService esListService;

    @Autowired
    public HangHoaServiceImpl(HangHoaRepository hdrRepo
                                ) {
        super(hdrRepo);
        this.hdrRepo = hdrRepo;
    }

    @Override
    public void pushProductData() throws Exception{
        HangHoaRep req = new HangHoaRep();
        req.setMaNhaThuoc("0012");
        var data = hdrRepo.searchList(req);
        esListService.pushProductData(data);
    }

    @Override
    public List<? extends Object> getProductData(HangHoaRep req) throws Exception {
        if(req.getTenThuoc() == null || req.getTenThuoc().equals(""))
            return new ArrayList<>();
//        List<Long> ids = new ArrayList<Long>();
//        if(req.getMaNhaThuoc() == "0012"){
//            ids = esListService.searchByTenThuoc(req.getTenThuoc());
//        }
//        if(ids.stream().count() > 0){
//            return redisListService.getHangHoaByIds(ids);
//        }else {
//            Pageable pageable = PageRequest.of(req.getPaggingReq().getPage(), req.getPaggingReq().getLimit());
//            //req.setMaNhaThuoc("0012");
//            req.setRecordStatusId(RecordStatusContains.ACTIVE);
//            var data = hdrRepo.searchPage(req, pageable);
//            return data.stream().toList();
//        }
        if(req.getPaggingReq() == null){
            var page = new PaggingReq();
            page.setLimit(25);
            page.setPage(0);
            req.setPaggingReq(page);
        }
        Pageable pageable = PageRequest.of(req.getPaggingReq().getPage(), req.getPaggingReq().getLimit());
        //req.setMaNhaThuoc("0012");
        req.setRecordStatusId(RecordStatusContains.ACTIVE);
        var data = hdrRepo.searchPage(req, pageable);
        return data.stream().toList();
    }

    public void saveProduct() throws Exception{
        var req = new HangHoaRep();
        req.setMaNhaThuoc("0012");
        req.setRecordStatusId(RecordStatusContains.ACTIVE);
        var list = hdrRepo.searchList(req);
        esListService.pushProductData(list);
    }
}
