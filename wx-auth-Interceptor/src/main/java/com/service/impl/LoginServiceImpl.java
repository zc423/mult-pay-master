package com.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.WxMaUserService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.auth.token.TokenKit;
import com.dto.WxLoginDTO;
import com.service.LoginService;
import com.vo.BusinessUserVO;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author DCZhang
 * @title LoginServiceImpl
 * @date 2023/5/19 13:27
 * @description TODO
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Resource
    private WxMaService wxMaService;

    @Override
    public String login(String username, String password) {
        String token = null;
        // 数据校验 校验用户名和密码是否正确
        if (true) {
            token = TokenKit.getToken(username);
        } else {
            throw new RuntimeException("用户名或密码错误");
        }
        return token;
    }

    @Override
    public BusinessUserVO wxLogin(WxLoginDTO wxLoginDTO) {
        BusinessUserVO businessUserVO = null;
        // 使用自定义登录态绑定用户信息，并保存到数据库
        WxMaUserInfo wxUserInfo = getWxUserInfo(wxLoginDTO);
//        businessUserVO = BusinessUserConvert.INSTANCE.toConvertBusinessUserVO(localInfo);
        // todo 查询用户是否存在，不存在则创建
        String token = TokenKit.getToken(wxUserInfo.getUnionId());
        return businessUserVO.setLoginInfo(token);

    }

    /**
     * 获取微信用户信息
     *
     * @param wxLoginDTO
     * @return
     */
    private WxMaUserInfo getWxUserInfo(WxLoginDTO wxLoginDTO) {
        // 调用 wei app API 完成登录验证，获取用户信息
        WxMaJscode2SessionResult sessionResult = null;
        sessionResult = getWxMaJsCode2Session(wxLoginDTO.getCode());
        String sessionKey = sessionResult.getSessionKey();
        WxMaUserInfo userInfo = wxMaService.getUserService().getUserInfo(sessionKey, wxLoginDTO.getEncryptedData(), wxLoginDTO.getIv());
        return userInfo;
    }


    /**
     * 获取微信用户session key (校验用户是否登录微信)
     *
     * @param code
     * @return
     */
    private WxMaJscode2SessionResult getWxMaJsCode2Session(String code) {
        WxMaUserService wxMaUserService = wxMaService.getUserService();
        WxMaJscode2SessionResult sessionResult;
        try {
            sessionResult = wxMaUserService.getSessionInfo(code);
        } catch (WxErrorException e) {
            log.info(e.getMessage());
            throw new RuntimeException("获取微信用户sessionKey信息失败");
        }
        return sessionResult;
    }

    /**
     * 根据电话code获取电话
     *
     * @param phoneNumCode 不是登录时候的code，是电话获取按钮返回的code
     * @return 电话号码
     * @author wangjiang
     * @date 2023/4/26 15:58
     */
    public String getPhoneByCode(String phoneNumCode) {
        try {
            WxMaPhoneNumberInfo newPhoneNoInfo = wxMaService.getUserService().getNewPhoneNoInfo(phoneNumCode);
            return newPhoneNoInfo.getPhoneNumber();
        } catch (WxErrorException e) {
            throw new RuntimeException("获取电话失败");
        }
    }
}
