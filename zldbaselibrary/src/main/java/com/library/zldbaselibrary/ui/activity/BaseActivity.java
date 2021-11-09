package com.library.zldbaselibrary.ui.activity;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

abstract public class BaseActivity extends Activity {

    /**
     * 初始化布局ID。
     *
     * @return 布局ID
     */
    abstract public int layoutId();

    /**
     * 展示加载弹框
     */
    abstract public void showLoadingDialog(Context context, @Nullable String msg);

    /**
     * 关闭弹框
     */
    abstract public void dismissLoadingDialog();


    /**
     * 展示文字信息
     */
    abstract public void showMsg(@NonNull String msg);
}
