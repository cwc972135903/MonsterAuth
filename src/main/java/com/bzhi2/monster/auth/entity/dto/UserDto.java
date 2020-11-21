package com.bzhi2.monster.auth.entity.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 * 用户查询dto
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/11/21 21:37
 */
@Getter
@Setter
public class UserDto {

    private Long userId;

    private String username;

    private String nickName;

    private String email;

    private String phone;

    private String gender;

    private String password;
}
