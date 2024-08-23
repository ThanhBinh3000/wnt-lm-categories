package vn.com.gsoft.categories.service;

import vn.com.gsoft.categories.entity.Thuocs;

import java.io.IOException;
import java.util.List;

public interface ESListService {
   void pushProductData(List<Thuocs> data) throws Exception;
   List<Long> searchByTenThuoc(String tenThuoc) throws IOException;
}
