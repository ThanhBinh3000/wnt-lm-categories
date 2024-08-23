package vn.com.gsoft.categories.service;

import vn.com.gsoft.categories.entity.Thuocs;
import vn.com.gsoft.categories.model.dto.HangHoaRep;

import java.util.List;

public interface HangHoaService extends BaseService<Thuocs, HangHoaRep, Long> {

    void pushProductData() throws Exception;

    List<? extends Object> getProductData(HangHoaRep req) throws Exception;

    void saveProduct() throws Exception;
}