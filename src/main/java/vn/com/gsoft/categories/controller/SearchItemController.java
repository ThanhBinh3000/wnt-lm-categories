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
  @Autowired
  private NhomNganhHangService nhomNganhHangService;
  @Autowired
  private NhomDuocLyService nhomDuocLyService;
  @Autowired
  private NhomHoatChatService nhomHoatChatService;
  @Autowired
  private NhaCungCapService nhaCungCapService;

  //region NHOM THUOC
  @PostMapping(value = PathConstant.URL_SEARCH_LIST + "-nhom-thuoc", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> searchListNhomThuoc(@RequestBody NhomThuocReq req) throws Exception {
    return ResponseEntity.ok(ResponseUtils.ok(nhomThuocService.searchList(req)));
  }

  @PostMapping(value = PathConstant.URL_SEARCH_PAGE + "-nhom-thuoc", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> searchPageNhomThuoc(@RequestBody NhomThuocReq req) throws Exception {
    return ResponseEntity.ok(ResponseUtils.ok(nhomThuocService.searchList(req)));
  }
  //endregion

  //region THUOC
  @PostMapping(value = PathConstant.URL_SEARCH_PAGE + "-thuoc", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> searchPageThuoc(@RequestBody HangHoaRep req) throws Exception {
    return ResponseEntity.ok(ResponseUtils.ok(hangHoaService.searchPage(req)));
  }

  @PostMapping(value = PathConstant.URL_SEARCH_LIST + "-thuoc", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> searchListThuoc(@RequestBody HangHoaRep req) throws Exception {
    return ResponseEntity.ok(ResponseUtils.ok(hangHoaService.getProductData(req)));
  }
  //endregion

  //region NHOM NGANH HANG
  @PostMapping(value = PathConstant.URL_SEARCH_LIST + "-nhom-nganh-hang", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> searchListNhomNganhHang(@RequestBody NhomNganhHangReq req) throws Exception {
    return ResponseEntity.ok(ResponseUtils.ok(nhomNganhHangService.searchList(req)));
  }

  @PostMapping(value = PathConstant.URL_SEARCH_PAGE + "-nhom-nganh-hang", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> searchPageNhomNganhHang(@RequestBody NhomNganhHangReq req) throws Exception {
    return ResponseEntity.ok(ResponseUtils.ok(nhomNganhHangService.searchPage(req)));
  }
  //endregion

  //region NHOM DUOC LY
  @PostMapping(value = PathConstant.URL_SEARCH_LIST + "-nhom-duoc-ly", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> searchListNhomDuocLy(@RequestBody NhomDuocLyReq req) throws Exception {
    return ResponseEntity.ok(ResponseUtils.ok(nhomDuocLyService.searchList(req)));
  }

  @PostMapping(value = PathConstant.URL_SEARCH_PAGE + "-nhom-duoc-ly", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> searchPageNhomDuocLy(@RequestBody NhomDuocLyReq req) throws Exception {
    return ResponseEntity.ok(ResponseUtils.ok(nhomDuocLyService.searchPage(req)));
  }
  //endregion

  //region NHOM HOAT CHAT
  @PostMapping(value = PathConstant.URL_SEARCH_LIST + "-nhom-hoat-chat", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> searchListNhomHoatChat(@RequestBody NhomHoatChatReq req) throws Exception {
    return ResponseEntity.ok(ResponseUtils.ok(nhomHoatChatService.searchList(req)));
  }

  @PostMapping(value = PathConstant.URL_SEARCH_PAGE + "-nhom-hoat-chat", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> searchPageNhomHoatChat(@RequestBody NhomHoatChatReq req) throws Exception {
    return ResponseEntity.ok(ResponseUtils.ok(nhomHoatChatService.searchPage(req)));
  }
  //endregion

  //region NHA CUNG CAP
  @PostMapping(value = PathConstant.URL_SEARCH_LIST + "-nha-cung-cap", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> searchListNhaCungCap(@RequestBody NhaCungCapReq req) throws Exception {
    return ResponseEntity.ok(ResponseUtils.ok(nhaCungCapService.searchList(req)));
  }

  @PostMapping(value = PathConstant.URL_SEARCH_PAGE + "-nha-cung-cap", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> searchPageNhaCungCap(@RequestBody NhaCungCapReq req) throws Exception {
    return ResponseEntity.ok(ResponseUtils.ok(nhaCungCapService.searchPage(req)));
  }
  //endregion
}
