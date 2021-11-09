package com.library.zldbaselibrary.presenter;

import com.library.zldbaselibrary.view.BaseView;

public class BasePresenter<V extends BaseView> {

    /** 视图层引用 */
    private V mView;

    /**
     * 绑定视图层
     */
    public void attach(V view) {
        this.mView = view;
    }

    /**
     * 调用此方法之后，Presenter将与界面解绑，防止内存泄漏。
     */
    public void detach() {
        if (mView != null) {
            mView = null;
        }
    }


    /**
     * 提供给子类，用于调用界面层相关的方法。
     * 注意此方法可能返回Null，调用者应该加以判断。
     *
     * @return View层的引用
     */
    public V getView() {
        return mView;
    }
}
