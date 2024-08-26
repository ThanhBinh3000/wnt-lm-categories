package vn.com.gsoft.categories.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.entity.NhaCungCaps;
import vn.com.gsoft.categories.entity.NhomThuoc;
import vn.com.gsoft.categories.model.dto.NhaCungCapReq;
import vn.com.gsoft.categories.model.dto.NhomThuocReq;
import vn.com.gsoft.categories.repository.NhaCungCapRepository;
import vn.com.gsoft.categories.repository.NhomThuocRepository;
import vn.com.gsoft.categories.service.NhaCungCapService;
import vn.com.gsoft.categories.service.NhomThuocService;

import java.util.List;


@Service
@Log4j2
public class NhaCungCapServiceImpl extends BaseServiceImpl<NhaCungCaps, NhaCungCapReq,Long> implements NhaCungCapService {

	private NhaCungCapRepository hdrRepo;
	@Autowired
	public NhaCungCapServiceImpl(NhaCungCapRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}

	@Override
	public Page<NhaCungCaps> searchPage(NhaCungCapReq req){
		//req.setMaNhaThuoc("0012");
		Pageable pageable = PageRequest.of(1, 25);
		return hdrRepo.searchPage(req, pageable);
	}

	@Override
	public List<NhaCungCaps> searchList(NhaCungCapReq req){
		//req.setMaNhaThuoc("0012");
		return hdrRepo.searchList(req);
	}

}
