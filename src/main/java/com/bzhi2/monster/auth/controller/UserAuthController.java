package com.bzhi2.monster.auth.controller;

import com.bzhi2.monster.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/11/21 22:35
 */
@RestController
@RequestMapping(value = "/auth")
public class UserAuthController {

    @Autowired
    private UserService userService;

    /**
     * 根据用户名称查询用户列表
     * @param userName
     * @return
     */
    @GetMapping(value = {"/queryUserList/{userName}", "/queryUserList"})
    public ResponseEntity queryUserListByName(@PathVariable(value = "userName", required = false) String userName){
        return new ResponseEntity(userService.findUserListByName(userName), HttpStatus.OK);
    }
}
