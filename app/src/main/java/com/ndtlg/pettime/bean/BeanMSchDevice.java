package com.ndtlg.pettime.bean;

import android.os.Build;

import com.ndtlg.pettime.F;

import static com.ndtlg.pettime.F.getMd5;
import static com.ndtlg.pettime.F.uid;

/**
 * Created by DELL on 2019/3/25.
 */

public class BeanMSchDevice {
    public  int pageSize = 20;
    public  int pageNumber = 1;
    public  String userid = uid;
    public String verify = F.verify;
    public  String device = "andriod";
    public  String deviceid = Build.SERIAL;
    public String md5;


    public BeanMSchDevice() {
        md5 = getMd5(this);
    }
}
