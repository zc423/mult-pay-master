package com.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author DCZhang
 * @title WxLoginDTO
 * @date 2023/5/8 17:32
 * @description TODO
 */
@Data
@Accessors(chain = true)
public class WxLoginDTO {
    private String code;
    private String encryptedData;
    private String iv;
}
