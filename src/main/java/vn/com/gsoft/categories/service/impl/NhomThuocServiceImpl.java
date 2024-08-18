package vn.com.gsoft.categories.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.entity.Cities;
import vn.com.gsoft.categories.entity.NhomThuoc;
import vn.com.gsoft.categories.model.dto.CitiesReq;
import vn.com.gsoft.categories.model.dto.NhomThuocReq;
import vn.com.gsoft.categories.repository.CitiesRepository;
import vn.com.gsoft.categories.repository.NhomThuocRepository;
import vn.com.gsoft.categories.service.CitiesService;
import vn.com.gsoft.categories.service.NhomThuocService;


@Service
@Log4j2
public class NhomThuocServiceImpl extends BaseServiceImpl<NhomThuoc, NhomThuocReq,Long> implements NhomThuocService {

	private NhomThuocRepository hdrRepo;
	@Autowired
	public NhomThuocServiceImpl(NhomThuocRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}

}
