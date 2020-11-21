package com.bzhi2.monster.auth.service;

import com.bzhi2.monster.auth.entity.UserEntity;
import com.bzhi2.monster.auth.entity.dto.UserDto;

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
public interface UserService {
    /**
     * 获取用户数据根据名称模糊查询
     * @param userName
     * @return
     */
    List<UserDto> findUserListByName(String userName);
}
