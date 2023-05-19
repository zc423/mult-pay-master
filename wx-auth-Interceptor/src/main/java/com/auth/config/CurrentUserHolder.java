package com.auth.config;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.entity.User;

import java.util.Optional;

public class CurrentUserHolder {
    private static final ThreadLocal<User> THREAD_LOCAL = new TransmittableThreadLocal<>();

    public static User getUser() {
        return Optional.ofNullable(THREAD_LOCAL.get()).orElse(new User(0L, "SYSTEM"));
    }

    public static void setUser(User user) {
        THREAD_LOCAL.set(user);
    }

    public static void clear() {
        THREAD_LOCAL.remove();
    }
}