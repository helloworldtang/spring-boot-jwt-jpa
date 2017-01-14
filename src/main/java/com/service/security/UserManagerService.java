package com.service.security;

import com.repository.UserAuthorityRepository;
import com.repository.UserRepository;
import com.domain.security.Role;
import com.domain.security.User;
import com.domain.security.UserAuthority;
import com.request.UserReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by tang.cheng on 2017/1/14.
 */
@Service
public class UserManagerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserManagerService.class);
    @Autowired
    private UserAuthorityRepository userAuthorityRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 每一个创建的一定是管理员
     *
     * @return
     */
    public boolean hasAdminAccount() {
        return userAuthorityRepository.count() > 0;
    }

    public void addAdminAccount(UserReq req) {
        User user = new User();
        user.setUsername(req.getUsername());
        String encodePwd = passwordEncoder.encode(req.getPassword());
        LOGGER.info("{}",encodePwd);
        user.setPassword(encodePwd);
        user.setFirstName(req.getFirstName());
        user.setLastName(req.getLastName());
        user.setEmail(req.getEmail());
        user.setEnabled(true);
        user.setLastPasswordResetDate(new Date());
        userRepository.save(user);

        UserAuthority authority = new UserAuthority();
        authority.setUserId(user.getId());
        authority.setAuthorityId(Role.ADMIN.getId());
        userAuthorityRepository.save(authority);
    }
}
