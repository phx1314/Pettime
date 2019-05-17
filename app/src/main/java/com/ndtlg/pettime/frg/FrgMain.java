//
//  FrgMain
//
//  Created by DELL on 2019-03-22 16:44:22
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.pettime.frg;

import android.os.Bundle;

import com.ab.view.listener.AbOnListViewListener;
import com.mdx.framework.adapter.MAdapter;
import com.ndtlg.pettime.R;
import com.ndtlg.pettime.ada.AdaMain;
import com.ndtlg.pettime.bean.BeanMSchDevice;
import com.ndtlg.pettime.model.ModelData;
import com.ndtlg.pettime.model.ModelList;

import java.util.ArrayList;
import java.util.List;

import static com.ndtlg.pettime.F.MSchDevice;
import static com.ndtlg.pettime.F.json2Model;


public class FrgMain extends BaseFrg {


    public com.ndtlg.pettime.view.AbPullListView mAbPullListView;

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_main);
        initView();
        loaddata();
    }

    @Override
    public void disposeMsg(int type, Object obj) {
        switch (type) {
            case 0:
                mAbPullListView.pullLoad();
                break;
        }
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {


        mAbPullListView = (com.ndtlg.pettime.view.AbPullListView) findViewById(R.id.mAbPullListView);
    }

    public void loaddata() {
        mAbPullListView.setGetApiLoadParams(MSchDevice, new BeanMSchDevice());
        mAbPullListView.setAbOnListViewListener(new AbOnListViewListener() {
            @Override
            public MAdapter onSuccess(String methodName, String content) {
                ModelList mModelList = (ModelList) json2Model(content, ModelList.class);
                mModelList.data.deviceList.add(new ModelList.DataBean.DeviceListBean());
                List data = new ArrayList();
                for (int i = 0; i < mModelList.data.deviceList.size(); i++) {
                    if (i % 2 == 0) {
                        ModelData mModelData = new ModelData();
                        for (int j = i; j < Math.min(mModelList.data.deviceList.size(), i + 2); j++) {
                            mModelData.mList.add(mModelList.data.deviceList.get(j));
                        }
                        data.add(mModelData);
                    }
                }
                return new AdaMain(getContext(), data);
            }
        });
    }


}