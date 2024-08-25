package vn.com.gsoft.categories.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.constant.NotificationContains;
import vn.com.gsoft.categories.entity.NhomThuoc;
import vn.com.gsoft.categories.entity.Notification;
import vn.com.gsoft.categories.model.dto.NhomThuocReq;
import vn.com.gsoft.categories.model.dto.NotificationReq;
import vn.com.gsoft.categories.model.system.Profile;
import vn.com.gsoft.categories.repository.NhomThuocRepository;
import vn.com.gsoft.categories.repository.NotificationRepository;
import vn.com.gsoft.categories.service.NhomThuocService;
import vn.com.gsoft.categories.service.NotificationService;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;


@Service
@Log4j2
public class NotificationServiceImpl extends BaseServiceImpl<Notification, NotificationReq,Long> implements NotificationService {

	private NotificationRepository hdrRepo;
	@Autowired
	public NotificationServiceImpl(NotificationRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}

	@Override
	public Page<Notification> searchPage(NotificationReq req) throws Exception{
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");
		if(userInfo.getMaCoSo() == null || userInfo.getMaCoSo().equals(""))
			return null;

		req.setDrugStoreId(userInfo.getMaCoSo());
		req.setNotificationTypeID(NotificationContains.THONG_BAO_LIEN_MINH);
		Pageable pageable = PageRequest.of(req.getPaggingReq().getPage(), req.getPaggingReq().getLimit());
        var data = hdrRepo.searchPage(req, pageable);
		data.stream().forEach(x->{
			if(x.getCreateDate() != null){
				x.setCreateDateTxt(fnGetTime(x.getCreateDate()));
			}
		});
		return data;
	}

	@Override
	public List<Notification> searchList(NotificationReq req) throws Exception{
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");
		if(userInfo.getMaCoSo() == null || userInfo.getMaCoSo().equals(""))
			return null;
		req.setDrugStoreId(userInfo.getMaCoSo());
		req.setNotificationTypeID(NotificationContains.THONG_BAO_LIEN_MINH);
		var lst = hdrRepo.searchList(req);
		lst.forEach(x->{
           if(x.getCreateDate() != null){
			   x.setCreateDateTxt(fnGetTime(x.getCreateDate()));
		   }
		});
		return lst;
	}

	private String fnGetTime(Date date) {
		Instant instant = date.toInstant();
		ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());

		ZonedDateTime now = ZonedDateTime.now();

		Duration duration = Duration.between(zonedDateTime, now);
		if (duration.toMinutes() < 60) {
			return duration.toMinutes() + " phút trước";
		} else if (duration.toHours() < 24) {
			return duration.toHours() + " giờ trước";
		} else {
			return duration.toDays() + " ngày trước";
		}
	}

}
