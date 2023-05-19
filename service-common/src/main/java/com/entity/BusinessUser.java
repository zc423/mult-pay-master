package com.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 小程序用户表
 */
@Data
@Accessors(chain = true)
public class BusinessUser implements Serializable,Cloneable {
    /** 微信open_id */
    private String openId ;
    /** 昵称 */
    private String nickName ;
    /** 头像 */
    private String headImage ;
    /** 上次登录设备 */
    private String lastLoginDevice ;
    /** 上次登录IP */
    private String lastLoginIp ;
    /** 上次登录时间 */
    private Date lastLoginTime ;
    /** 账户卡号 */
    private String accountSn ;
    /** 微信union_id */
    private String unionId;
    /**
     *  手机号
     */
    private String phone;
    /**
     * 用户id(平台) @see SysUser
     */
    private Long userId;
    /** 是否首次登录 */
    private Integer firstLogin;

}