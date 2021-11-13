package com.library.zldbaselibrary.net;

import com.library.zldbaselibrary.net.resp.BaseResp;
import com.trello.rxlifecycle4.RxLifecycle;
import com.trello.rxlifecycle4.android.ActivityEvent;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * 作者：Lxw
 * 时间：2021-11-11 17:50
 * <p>
 * 注释：网络访问框架的封装体，配合{@link RetrofitFactory}使用
 */
public class Http {

    /** 单例模式 */
    private static Http mInstance;


    /**
     * 单例模式防止外部构建实例
     */
    private Http() {
    }

    /**
     * 单例模式获取实例
     *
     * @return 单例对象
     */
    public static Http getInstance() {
        if (mInstance == null) {
            synchronized (Http.class) {
                if (mInstance == null) {
                    mInstance = new Http();
                }
            }
        }
        return mInstance;
    }


    /**
     * 执行网络请求
     *
     * @param observable 由Retrofit构建的 Observable 要构建一个请求的Observable，请参考{@link RetrofitFactory#create(Class)}
     * @param callBack   请求回调
     * @param lifecycle  生命周期控制，当界面被destroy了之后网络请求会自动取消
     * @param <T>        这是网络请求的结果泛型，例如网络请求最终会返回一个 用户信息，那么这里就是 UserInfo
     */
    public <T> void execute(Observable<BaseResp<T>> observable, CallBack<T> callBack, Observable<ActivityEvent> lifecycle) {
        observable.flatMap(new ReqFunc<>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .compose(RxLifecycle.bindUntilEvent(lifecycle, ActivityEvent.DESTROY))
                .subscribe(callBack);
    }
}
