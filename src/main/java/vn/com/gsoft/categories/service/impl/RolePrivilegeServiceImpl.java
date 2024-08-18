package vn.com.gsoft.categories.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.entity.RolePrivilege;
import vn.com.gsoft.categories.model.dto.RolePrivilegeReq;
import vn.com.gsoft.categories.repository.RolePrivilegeRepository;
import vn.com.gsoft.categories.service.RolePrivilegeService;

@Service
public class RolePrivilegeServiceImpl extends BaseServiceImpl<RolePrivilege, RolePrivilegeReq, Long> implements RolePrivilegeService {
    private RolePrivilegeRepository hdrRepo;

    @Autowired
    public RolePrivilegeServiceImpl(RolePrivilegeRepository hdrRepo) {
        super(hdrRepo);
        this.hdrRepo = hdrRepo;
    }
}
