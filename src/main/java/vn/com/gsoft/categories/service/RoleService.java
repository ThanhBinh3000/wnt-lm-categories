package vn.com.gsoft.categories.service;

import vn.com.gsoft.categories.entity.Role;
import vn.com.gsoft.categories.model.dto.RoleReq;

import java.util.Optional;

public interface RoleService extends BaseService<Role, RoleReq, Long> {


    Optional<Role> findByTypeAndIsDefaultAndRoleName(int type, boolean isDefault, String roleName);

    Optional<Role> findByMaNhaThuocAndTypeAndIsDefaultAndRoleName(String maNhaThuoc, int type, boolean isDefault, String roleName);
}