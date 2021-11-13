package com.library.zldbaselibrary.net;

import com.library.zldbaselibrary.util.L;
import com.library.zldbaselibrary.view.BaseView;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * 作者：Lxw
 * 时间：2021-11-13 11:19
 * <p>
 * 注释：这是网络框架的基础回调，为什么要传入一个BaseView呢？ 是因为这里的{@link CallBack#onError(Throwable)}方法帮助调用者
 * 处理了最基本的取消加载框操作。也就是说一旦出现错误（例如：网络错误、逻辑错误等等）这里会第一时间将界面的加载弹框dismiss。
 */
abstract public class CallBack<T> implements Observer<T> {

    /** 请求响应的Observer,可以处理最基础的逻辑，例如隐藏加载框 */
    private final BaseView mView;

    public CallBack(BaseView view) {
        this.mView = view;
    }


    /**
     * 仅做最基础的取消加载框
     *
     * @param e 抛出的异常
     */
    @Override
    public void onError(@NonNull Throwable e) {
        if (mView != null) {
            mView.dismissLoadingDialog();
        }
    }

    @Override
    public void onComplete() {
    }


    @Override
    public void onSubscribe(@NonNull Disposable d) {
    }

}