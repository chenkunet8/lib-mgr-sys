package com.ck.chenkunet.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserTeacher {
    int id;
    String name;
    String phone;
    String post;
    String academy;
    String pwd;

    /**
     * 密码隐藏
     *
     * @param str
     */
    public void setPwd(String str) {
        this.pwd = "***";
    }
}
