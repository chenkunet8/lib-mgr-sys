package com.ck.chenkunet.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 管理员用户
 */
@Data
@AllArgsConstructor
public class UserManager {

    int id;
    String name;
    String status;
}
