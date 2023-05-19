package com.controller;

import com.dto.WxLoginDTO;
import com.service.LoginService;
import com.vo.BusinessUserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author DCZhang
 * @title LoginController
 * @date 2023/5/19 13:21
 * @description TODO
 */
@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/login/{username}/{password}")
    public String login(@PathVariable String username, @PathVariable String password) {
        String token = loginService.login(username, password);
        return token;
    }
    @GetMapping("/wxLogin")
    public BusinessUserVO wxLogin(@RequestBody WxLoginDTO wxLoginDTO) {
        BusinessUserVO businessUserVO = loginService.wxLogin(wxLoginDTO);
        return businessUserVO;
    }

}
