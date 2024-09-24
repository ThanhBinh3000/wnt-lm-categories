package vn.com.gsoft.categories.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.gsoft.categories.constant.PathConstant;
import vn.com.gsoft.categories.entity.Notification;
import vn.com.gsoft.categories.model.dto.CitiesReq;
import vn.com.gsoft.categories.model.dto.NotificationReq;
import vn.com.gsoft.categories.model.dto.RegionsReq;
import vn.com.gsoft.categories.model.dto.WardsReq;
import vn.com.gsoft.categories.response.BaseResponse;
import vn.com.gsoft.categories.service.CitiesService;
import vn.com.gsoft.categories.service.NotificationService;
import vn.com.gsoft.categories.service.RegionsService;
import vn.com.gsoft.categories.service.WardsService;
import vn.com.gsoft.categories.util.system.ResponseUtils;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/thong-bao")
public class NotificationController {
	
  @Autowired
  private NotificationService service;

  @PostMapping(value = PathConstant.URL_SEARCH_PAGE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> searchPage(@RequestBody NotificationReq req) throws Exception {
    return ResponseEntity.ok(ResponseUtils.ok(service.searchList(req)));
  }

  @PostMapping(value = PathConstant.URL_SEARCH_LIST, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> searchList(@RequestBody NotificationReq req) throws Exception {
    return ResponseEntity.ok(ResponseUtils.ok(service.searchList(req)));
  }

  @PostMapping(value = PathConstant.URL_UPDATE + "-trang-thai", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> updateStatus(@RequestBody List<Notification> items) throws Exception {
    return ResponseEntity.ok(ResponseUtils.ok(service.updateStatus(items)));
  }
}
