package vn.com.gsoft.categories.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.entity.NhomDuocLy;
import vn.com.gsoft.categories.entity.NhomNganhHang;
import vn.com.gsoft.categories.model.dto.NhomDuocLyReq;
import vn.com.gsoft.categories.model.dto.NhomNganhHangReq;
import vn.com.gsoft.categories.repository.NhomDuocLyRepository;
import vn.com.gsoft.categories.repository.NhomNganhHangRepository;
import vn.com.gsoft.categories.service.NhomDuocLyService;
import vn.com.gsoft.categories.service.NhomNganhHangService;


@Service
@Log4j2
public class NhomDuoclyServiceImpl extends BaseServiceImpl<NhomDuocLy, NhomDuocLyReq,Long> implements NhomDuocLyService {

	private NhomDuocLyRepository hdrRepo;
	@Autowired
	public NhomDuoclyServiceImpl(NhomDuocLyRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}

}
