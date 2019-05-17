package com.ndtlg.pettime.bean;

import android.os.Build;

import java.io.File;

import static com.ndtlg.pettime.F.getMd5;
import static com.ndtlg.pettime.F.uid;

/**
 * Created by DELL on 2019/3/25.
 */

public class BeanMUploadFile {
    String userid = uid;
    File mFile;
    String deviceid = Build.SERIAL;
    String device = "andriod";
    String md5 = "";


    public BeanMUploadFile(File mFile) {
        this.mFile = mFile;
        md5 = getMd5(this);
    }
}
