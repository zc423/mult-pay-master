package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author DCZhang
 * @title User
 * @date 2023/5/19 11:01
 * @description TODO
 */
@Data
@AllArgsConstructor
public class User {
    private Long id;

    private String name;

    private String password;
    private final String username;

    private List<String> roles;

}
