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

import java.util.List;


@Service
@Log4j2
public class NhomDuoclyServiceImpl extends BaseServiceImpl<NhomDuocLy, NhomDuocLyReq,Long> implements NhomDuocLyService {

	@Autowired
	private NhomDuocLyRepository hdrRepo;
	@Autowired
	private NhomNganhHangRepository nganhHangRepository;
	@Autowired
	public NhomDuoclyServiceImpl(NhomDuocLyRepository hdrRepo,
								 NhomNganhHangRepository nganhHangRepository) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
		this.nganhHangRepository = nganhHangRepository;
	}
	@Override
	public List<NhomDuocLy> searchList(NhomDuocLyReq req){
		//kiem tra nhom nganh hang la tpcn
		if(req.getNhomNganhHangId() > 0){
			var nh = nganhHangRepository.findById(Long.valueOf(req.getNhomNganhHangId()));
			if(nh != null && !nh.get().getTenNganhHang().equals("Thực phẩm chức năng")){
				req.setNhomNganhHangId(0);
			}
		}
		return hdrRepo.searchList(req);
	}

}
