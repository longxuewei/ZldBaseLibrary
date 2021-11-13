package com.library.zldbaselibrary.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.library.zldbaselibrary.presenter.BasePresenter;
import com.library.zldbaselibrary.ui.dialog.CommonLoading;
import com.library.zldbaselibrary.ui.dialog.ILoading;
import com.library.zldbaselibrary.view.BaseView;

/**
 * 作者：Lxw
 * 时间：2021-11-09 16:18
 * <p>
 * 注释：MVP 模式下的Fragment基类，用于该类处理了最基本的 P 层和 V层的绑定以及其他基础工作，减少子类的重复性代码，所有复杂（需要使用MVP分层）的页面
 * 都应该集成该类。
 */
public abstract class BaseMvpFragment<V extends BaseView, P extends BasePresenter<V>> extends BaseFragment implements BaseView {

    /** 加载框样式；如子类有特殊样式，请覆盖 {@link BaseMvpFragment#initLoading()} 以自定义 */
    private ILoading mLoading;

    /** P层引用；用于处理界面逻辑 */
    public P mPresenter;

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        //实例化Presenter层
        mPresenter = initPresenter();
        mPresenter.attach((V) this);

        //调用父类初始化视图
        super.onViewCreated(view, savedInstanceState);

        //初始化默认的加载框样式
        mLoading = initLoading();
    }

    /**
     * 初始化Presenter逻辑层
     *
     * @return 实例化Presenter层，用于处理界面相关的逻辑
     */
    @NonNull
    public abstract P initPresenter();


    /**
     * 默认的加载框样式/如需使用自定义的样式请付盖此方法
     */
    public ILoading initLoading() {
        return new CommonLoading();
    }


    /**
     * 展示加载弹框
     *
     * @param context 上下文
     * @param msg     加载弹框上的文字信息，可以为空或空字符串；如果为空或空字符串则不展示文本信息。
     */
    @Override
    public void showLoadingDialog(Context context, @Nullable String msg) {
        if (mLoading != null) {
            mLoading.showLoadingDialog(context, msg);
        }
    }

    /**
     * 关闭加载弹框
     */
    @Override
    public void dismissLoadingDialog() {
        if (mLoading != null) {
            mLoading.dismissLoadingDialog();
        }
    }


    /**
     * 展示文字信息
     *
     * @param msg 需要展示的文字信息
     */
    @Override
    public void showMsg(@NonNull String msg) {
        if (mLoading != null) {
            mLoading.showMsg(msg);
        }
    }


    /**
     * 资源释放
     */
    @Override
    public void onDetach() {
        super.onDetach();
        //与Presenter层断开链接
        if (mPresenter != null) {
            mPresenter.detach();
        }
    }
}