package com.ndtlg.pettime.bean;

import android.os.Build;

import com.ndtlg.pettime.F;

import static com.ndtlg.pettime.F.getMd5;
import static com.ndtlg.pettime.F.uid;

/**
 * Created by DELL on 2019/3/25.
 */

public class BeanBind {
    String nickName;
    String header;
    int sex;
    String wxqqid;
    String type;
    String verify = F.verify;
    String device = "andriod";
    String deviceid = Build.SERIAL;
    String userid = uid;
    String md5;


    public BeanBind(String wxqqid, String type, String nickName, String header, int sex) {
        this.nickName = nickName;
        this.header = header;
        this.sex = sex;
        this.wxqqid = wxqqid;
        this.type = type;
        md5 = getMd5(this);
    }
}
