package vn.com.gsoft.categories.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.entity.NhomNganhHang;
import vn.com.gsoft.categories.entity.NhomThuoc;
import vn.com.gsoft.categories.model.dto.NhomNganhHangReq;
import vn.com.gsoft.categories.model.dto.NhomThuocReq;
import vn.com.gsoft.categories.repository.NhomNganhHangRepository;
import vn.com.gsoft.categories.repository.NhomThuocRepository;
import vn.com.gsoft.categories.service.NhomNganhHangService;
import vn.com.gsoft.categories.service.NhomThuocService;


@Service
@Log4j2
public class NhomNganhHangServiceImpl extends BaseServiceImpl<NhomNganhHang, NhomNganhHangReq,Long> implements NhomNganhHangService {

	private NhomNganhHangRepository hdrRepo;
	@Autowired
	public NhomNganhHangServiceImpl(NhomNganhHangRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}

}
