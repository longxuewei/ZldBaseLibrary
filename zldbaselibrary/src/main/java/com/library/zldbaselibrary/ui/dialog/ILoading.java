package com.library.zldbaselibrary.ui.dialog;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


/**
 * 这是加载弹框和普通文字信息展示的抽象类。如果想要展示不同样式的加载弹框可以实现该类进行自定义。
 */
public interface ILoading {


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
