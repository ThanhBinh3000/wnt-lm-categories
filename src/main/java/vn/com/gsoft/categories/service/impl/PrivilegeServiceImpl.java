package vn.com.gsoft.categories.service.impl;

import vn.com.gsoft.categories.entity.*;
import vn.com.gsoft.categories.model.dto.PrivilegeReq;
import vn.com.gsoft.categories.repository.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.service.PrivilegeService;


@Service
@Log4j2
public class PrivilegeServiceImpl extends BaseServiceImpl<Privilege, PrivilegeReq, Long> implements PrivilegeService {

    private PrivilegeRepository hdrRepo;

    @Autowired
    public PrivilegeServiceImpl(PrivilegeRepository hdrRepo) {
        super(hdrRepo);
        this.hdrRepo = hdrRepo;
    }

}
