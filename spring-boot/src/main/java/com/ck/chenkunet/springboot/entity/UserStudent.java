package com.ck.chenkunet.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserStudent extends User{

    int id;
    String sid;
    String academy;

    /**
     * 密码隐藏
     * @param str
     */
    public void setPwd(String str) {
        this.pwd = "***";
    }
}
