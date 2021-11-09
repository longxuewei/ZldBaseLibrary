package com.library.zldbaselibrary.view;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


/**
 * MVP中 VIEW 的基类，所有View应当实现该类，实现最基础的3个方法
 */
public interface BaseView {

    /**
     * 展示加载弹框
     *
     * @param context 上下文
     * @param msg     加载弹框上的文字信息，可以为空或空字符串；如果为空或空字符串则不展示文本信息。
     */
    void showLoadingDialog(Context context, @Nullable String msg);


    /**
     * 关闭加载弹框
     */
    void dismissLoadingDialog();


    /**
     * 展示文字信息
     *
     * @param msg 需要展示的文字信息
     */
    void showMsg(@NonNull String msg);

}