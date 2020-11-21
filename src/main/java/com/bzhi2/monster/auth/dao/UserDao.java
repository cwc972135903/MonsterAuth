package com.bzhi2.monster.auth.dao;

import com.bzhi2.monster.auth.entity.dto.UserDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/11/21 21:44
 */
public interface UserDao {
    List<UserDto> findUserListByName(@Param("userName") String userName);
}
