package com.service;

import com.dto.WxLoginDTO;
import com.vo.BusinessUserVO;

/**
 * @author DCZhang
 * @title LoginService
 * @date 2023/5/19 13:26
 * @description TODO
 */
public interface LoginService {
    String login(String username, String password);

    BusinessUserVO wxLogin(WxLoginDTO wxLoginDTO);
}
