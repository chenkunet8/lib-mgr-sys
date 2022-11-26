package com.ck.chenkunet.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserTeacher extends User {

    int id;
    String post;
    String academy;
    String status;

    /**
     * 密码隐藏
     *
     * @param str
     */
    public void setPwd(String str) {
        this.pwd = "***";
    }
}
