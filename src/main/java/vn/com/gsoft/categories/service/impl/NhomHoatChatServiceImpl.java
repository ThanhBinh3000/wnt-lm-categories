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


@Service
@Log4j2
public class NhomHoatChatServiceImpl extends BaseServiceImpl<NhomHoatChat, NhomHoatChatReq,Long> implements NhomHoatChatService {

	private NhomHoatChatRepository hdrRepo;
	@Autowired
	public NhomHoatChatServiceImpl(NhomHoatChatRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}

}
