package com.library.zldbaselibrary.ui.activity;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.library.zldbaselibrary.presenter.BasePresenter;
import com.library.zldbaselibrary.ui.dialog.CommonLoading;
import com.library.zldbaselibrary.ui.dialog.ILoading;
import com.library.zldbaselibrary.view.BaseView;

abstract public class BaseMvpActivity<V extends BaseView, T extends BasePresenter<V>> extends BaseActivity implements BaseView {


    /** 加载框样式；如子类有特殊样式，请覆盖 {@link BaseMvpActivity#initLoading()}  改变 */
    private ILoading mLoading;

    /** P层引用；用于处理界面逻辑 */
    T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //子类返回界面
        setContentView(layoutId());

        //初始化默认的加载框样式
        mLoading = initLoading();

        //实例化Presenter层
        mPresenter = initPresenter();
        mPresenter.attach((V) this);

        //开始初始化界面
        initView(savedInstanceState);
    }


    /**
     * 默认的加载框样式/如需使用自定义的样式请付盖此方法
     */
    public ILoading initLoading() {
        return new CommonLoading();
    }


    /**
     * 初始化Presenter逻辑层
     *
     * @return 实例化Presenter层，用于处理界面相关的逻辑
     */
    @NonNull
    abstract T initPresenter();


    /**
     * 初始化控件，子类可在此进行视图初始化。
     *
     * @param savedInstanceState 页面回收的保存实例，可用于恢复页面数据。
     */
    abstract public void initView(@Nullable Bundle savedInstanceState);


    /**
     * 资源释放
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();

        //与Presenter层断开链接
        if (mPresenter != null) {
            mPresenter.detach();
        }
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
}
