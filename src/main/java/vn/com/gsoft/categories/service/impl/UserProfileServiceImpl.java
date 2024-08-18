package vn.com.gsoft.categories.service.impl;


import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.constant.RoleTypeConstant;
import vn.com.gsoft.categories.entity.Role;
import vn.com.gsoft.categories.entity.UserProfile;
import vn.com.gsoft.categories.model.dto.*;
import vn.com.gsoft.categories.model.system.Profile;
import vn.com.gsoft.categories.repository.UserProfileRepository;
import vn.com.gsoft.categories.service.*;
import vn.com.gsoft.categories.util.system.DataUtils;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class UserProfileServiceImpl extends BaseServiceImpl<UserProfile, UserProfileReq, Long> implements UserProfileService {

    private UserProfileRepository hdrRepo;
    private PasswordEncoder passwordEncoder;
    private RoleService roleService;
    private UserRoleService userRoleService;

    @Autowired
    public UserProfileServiceImpl(UserProfileRepository hdrRepo, PasswordEncoder passwordEncoder, RoleService roleService, UserRoleService userRoleService) {
        super(hdrRepo);
        this.hdrRepo = hdrRepo;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
        this.userRoleService = userRoleService;
    }
}
