package com.library.zldbaselibrary.ui.activity;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.BarUtils;


/**
 * 界面基类，包含了最基础的操作。例如设置布局id，展示弹框等
 */
abstract public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
    }

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


    /**
     * 设置状态栏的文字图片颜色，防止页面白色和状态栏文字白色重叠导致看不到状态栏的文字
     *
     * @param isLightMode true：状态栏的文字/图标颜色将会变成黑色；false：则变为白色
     */
    public void setStatusBarLightMode(boolean isLightMode) {
        BarUtils.setStatusBarLightMode(this, isLightMode);
    }


    /**
     * 设置状态栏背景颜色
     *
     * @param color 请使用 getResources() 方法解析资源文件中的颜色， 而不是直接传入 R.color.xxx
     */
    public void setStatusBarColor(@ColorInt int color) {
        BarUtils.setStatusBarColor(this, color);
    }

    /**
     * 设置显示状态栏
     *
     * @param isVisible true：显示状态栏，false：隐藏状态栏
     */
    public void setStatusBarVisibility(boolean isVisible) {
        BarUtils.setStatusBarVisibility(this, isVisible);
    }

}
