package com.ndtlg.pettime.bean;

import android.os.Build;

import static com.ndtlg.pettime.F.getMd5;

/**
 * Created by DELL on 2019/3/25.
 */

public class BeanLogin {
    String phone;
    String password;
    String device = "andriod";
    String deviceid = Build.SERIAL;
    String md5 = "";

    public BeanLogin(String phone, String password) {
        this.phone = phone;
        this.password = password;
        md5 = getMd5(this);
    }
}
