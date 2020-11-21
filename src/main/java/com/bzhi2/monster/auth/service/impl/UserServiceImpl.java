package com.bzhi2.monster.auth.service.impl;

import com.bzhi2.monster.auth.dao.UserDao;
import com.bzhi2.monster.auth.entity.UserEntity;
import com.bzhi2.monster.auth.entity.dto.UserDto;
import com.bzhi2.monster.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/11/21 12:05
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<UserDto> findUserListByName(String userName) {
        return userDao.findUserListByName(userName);
    }
}
