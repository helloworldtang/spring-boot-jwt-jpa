package com.web.security;

import com.domain.request.FullUserReq;
import com.domain.request.UserReq;
import com.domain.security.SysRole;
import com.service.security.UserManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by tang.cheng on 2017/1/16.
 */

@Api(description = "User Manager", tags = "user manager")
@RestController
public class UserController {
    @Autowired
    private UserManagerService userManagerService;

    @ApiOperation("init user manager system")
    @RequestMapping(value = "/sys/auth/init", method = RequestMethod.POST)
    public ResponseEntity<String> init(@Valid @ModelAttribute UserReq req) {
        if (userManagerService.hasAdminAccount()) {
            return ResponseEntity.badRequest().body("Has been done!nothing to do.");
        }
        userManagerService.create(req, SysRole.ROLE_ADMIN.getId());
        return ResponseEntity.ok("success");
    }


    @ApiOperation("add user")
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ApiImplicitParam(name = "测试字段不用填", value = "username value", defaultValue = "admin", required = true, paramType = "query", example = "eg")
    public ResponseEntity<String> createUser(@Valid @ModelAttribute FullUserReq fullUserReq) {
        userManagerService.create(fullUserReq);
        return ResponseEntity.ok("success");
    }

    @ApiOperation("modify user info")
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public ResponseEntity<String> managerUser(@RequestParam(name = "username") String username, @RequestParam("status") Boolean status) {
        //todo 此处的用户名，token中已经存在，可以去掉
        userManagerService.manager(username, status);
        return ResponseEntity.ok("success");
    }

}
