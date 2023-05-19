package com.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author DCZhang
 * @title WxUserDTO
 * @date 2023/4/17 16:45
 * @description TODO
 */
@Data
@Accessors(chain = true)
public class BusinessUserVO implements Serializable {
    /** 微信open_id */
    private String openId ;
    /** 昵称 */
    private String nickName ;
    /** 头像 */
    private String headImage ;
    /** 账户卡号 */
    private String accountSn ;

    /** 微信union_id */
    private String unionId;
    /** 是否首次登录 */
    private Integer firstLogin;
    /**
     *  手机号
     */
    private String phone;
    /**
     * 用户id(平台) @see SysUser
     */
    private Long userId;
    /**
     * 登录信息
     */
    private Object loginInfo;
}
