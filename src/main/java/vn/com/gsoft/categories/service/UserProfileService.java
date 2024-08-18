package vn.com.gsoft.categories.service;

import org.springframework.data.domain.Page;
import vn.com.gsoft.categories.entity.UserProfile;
import vn.com.gsoft.categories.model.dto.UserProfileReq;
import vn.com.gsoft.categories.model.dto.UserStaffProfileRes;

import java.util.List;

public interface UserProfileService extends BaseService<UserProfile, UserProfileReq, Long> {
}