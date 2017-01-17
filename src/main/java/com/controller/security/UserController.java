package com.controller.security;

import com.domain.request.FullUserReq;
import com.domain.request.UserReq;
import com.domain.security.SysRole;
import com.service.security.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by tang.cheng on 2017/1/16.
 */
@RestController
public class UserController {
    @Autowired
    private UserManagerService userManagerService;

    @RequestMapping(value = "/login/init", method = RequestMethod.POST)
    public ResponseEntity<?> init(@Valid @ModelAttribute UserReq req) {
        if (userManagerService.hasAdminAccount()) {
            return ResponseEntity.badRequest().body("Has been done!nothing to do.");
        }
        userManagerService.create(req, SysRole.ROLE_ADMIN.getId());
        return ResponseEntity.ok("success");
    }


    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(name = "/login/user", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@Valid @ModelAttribute FullUserReq fullUserReq) {
        userManagerService.create(fullUserReq);
        return ResponseEntity.ok("success");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(name = "/login/user", method = RequestMethod.PUT)
    public ResponseEntity<?> managerUser(@RequestParam(name = "username") String username, @RequestParam("status") Boolean status) {
        userManagerService.manager(username,status);
        return ResponseEntity.ok("success");
    }

}
