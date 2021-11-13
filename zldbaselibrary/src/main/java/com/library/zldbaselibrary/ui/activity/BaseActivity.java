package com.library.zldbaselibrary.ui.activity;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.trello.rxlifecycle4.components.support.RxAppCompatActivity;

abstract public class BaseActivity extends RxAppCompatActivity {

    /**
     * 初始化布局ID。
     *
     * @return 布局ID
     */
    public abstract int layoutId();

    /**
     * 展示加载弹框
     */
    public abstract void showLoadingDialog(Context context, @Nullable String msg);

    /**
     * 关闭弹框
     */
    public abstract void dismissLoadingDialog();


    /**
     * 展示文字信息
     */
    public abstract void showMsg(@NonNull String msg);
}
