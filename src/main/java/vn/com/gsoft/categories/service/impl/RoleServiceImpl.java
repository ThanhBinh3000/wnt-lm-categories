package vn.com.gsoft.categories.service.impl;

import vn.com.gsoft.categories.entity.*;
import vn.com.gsoft.categories.model.dto.RoleReq;
import vn.com.gsoft.categories.repository.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.service.RoleService;

import java.util.Optional;


@Service
@Log4j2
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleReq, Long> implements RoleService {

    private RoleRepository hdrRepo;

    @Autowired
    public RoleServiceImpl(RoleRepository hdrRepo) {
        super(hdrRepo);
        this.hdrRepo = hdrRepo;
    }

    @Override
    public Optional<Role> findByTypeAndIsDefaultAndRoleName(int type, boolean isDefault, String roleName) {
        return this.hdrRepo.findByTypeAndIsDefault(type, isDefault, roleName);
    }

    @Override
    public Optional<Role> findByMaNhaThuocAndTypeAndIsDefaultAndRoleName(String maNhaThuoc, int type, boolean isDefault, String roleName) {
        return this.hdrRepo.findByMaNhaThuocAndTypeAndIsDefault(maNhaThuoc, type, isDefault, roleName);
    }
}
