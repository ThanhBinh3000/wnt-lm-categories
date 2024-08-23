package vn.com.gsoft.categories.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.entity.NhomDuocLy;
import vn.com.gsoft.categories.entity.NhomHoatChat;
import vn.com.gsoft.categories.model.dto.NhomDuocLyReq;
import vn.com.gsoft.categories.model.dto.NhomHoatChatReq;
import vn.com.gsoft.categories.repository.NhomDuocLyRepository;
import vn.com.gsoft.categories.repository.NhomHoatChatRepository;
import vn.com.gsoft.categories.service.NhomDuocLyService;
import vn.com.gsoft.categories.service.NhomHoatChatService;

import java.util.List;


@Service
@Log4j2
public class NhomHoatChatServiceImpl extends BaseServiceImpl<NhomHoatChat, NhomHoatChatReq,Long> implements NhomHoatChatService {

	private NhomHoatChatRepository hdrRepo;
	private NhomDuocLyRepository duocLyRepo;
	@Autowired
	public NhomHoatChatServiceImpl(NhomHoatChatRepository hdrRepo,
								   NhomDuocLyRepository duocLyRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
		this.duocLyRepo = duocLyRepo;
	}

	@Override
	public List<NhomHoatChat> searchList(NhomHoatChatReq req){
		//kiem tra nhom nganh hang la tpcn
		if(req.getNhomDuocLyId() > 0){
			var dl = duocLyRepo.findById(Long.valueOf(req.getNhomDuocLyId()));
			if(dl != null && dl.get().getNhomNganhHangId() == 0){
				req.setNhomDuocLyId(0);
			}
		}
		return hdrRepo.searchList(req);
	}

}
