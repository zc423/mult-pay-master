package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DCZhang
 * @title TestController
 * @date 2023/5/19 10:49
 * @description TODO
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/api/get")
    public String get() {
        return "get";
    }

}
