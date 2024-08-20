package vn.com.gsoft.categories.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.gsoft.categories.constant.PathConstant;
import vn.com.gsoft.categories.model.dto.*;
import vn.com.gsoft.categories.response.BaseResponse;
import vn.com.gsoft.categories.service.*;
import vn.com.gsoft.categories.util.system.ResponseUtils;

@Slf4j
@RestController
@RequestMapping("/tra-cuu")
public class SearchItemController {
	
  @Autowired
  private NhomThuocService nhomThuocService;
  @Autowired
  private HangHoaService hangHoaService;

  @PostMapping(value = PathConstant.URL_SEARCH_LIST + "-nhom-thuoc", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> searchPageNhomThuoc(@RequestBody NhomThuocReq req) throws Exception {
    return ResponseEntity.ok(ResponseUtils.ok(nhomThuocService.searchList(req)));
  }

  @PostMapping(value = PathConstant.URL_SEARCH_PAGE + "-nhom-thuoc", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> searchListNhomThuoc(@RequestBody NhomThuocReq req) throws Exception {
    return ResponseEntity.ok(ResponseUtils.ok(nhomThuocService.searchList(req)));
  }

  @PostMapping(value = PathConstant.URL_SEARCH_LIST + "-thuoc", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> searchPageThuoc(@RequestBody HangHoaRep req) throws Exception {
    return ResponseEntity.ok(ResponseUtils.ok(hangHoaService.searchPage(req)));
  }
}
