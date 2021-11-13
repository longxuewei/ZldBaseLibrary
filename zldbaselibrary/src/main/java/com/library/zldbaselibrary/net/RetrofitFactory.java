package com.library.zldbaselibrary.net;

import com.library.zldbaselibrary.common.BaseLibrary;
import com.library.zldbaselibrary.config.NetWorkConfig;
import com.trello.rxlifecycle4.LifecycleProvider;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：Lxw
 * 时间：2021-11-11 17:50
 * <p>
 * 注释：网络访问框架的封装体，这里封装了最基础的Retrofit和Okhttp，请注意在调用者在使用前应该在自己的Application中进行网络配置{@link NetWorkConfig}，
 * 当要调用某个接口时，请将对应的接口Class文件传入{@link RetrofitFactory#create(Class)}方法。
 */
public class RetrofitFactory {

    /** 单例模式 */
    private static RetrofitFactory mInstance;

    /** Retrofit 实例 */
    private final Retrofit mRetrofit;


    private RetrofitFactory() {
        //网络基础域名
        String baseUrl = BaseLibrary.getInstance().getNetWorkConfig().getBaseUrl();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(initClient())
                .build();
    }


    /**
     * 初始化网络调用客户端
     *
     * @return Okhttp的实例，后期所有网络交互都使用此配置
     */
    private OkHttpClient initClient() {
        NetWorkConfig netWorkConfig = BaseLibrary.getInstance().getNetWorkConfig();

        List<Interceptor> interceptors = netWorkConfig.getInterceptors();

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .readTimeout(netWorkConfig.getReadTimeout(), TimeUnit.SECONDS)
                .writeTimeout(netWorkConfig.getWriteTimeout(), TimeUnit.SECONDS)
                .connectTimeout(netWorkConfig.getConnectTimeout(), TimeUnit.SECONDS);
        if (interceptors != null && !interceptors.isEmpty()) {
            for (Interceptor intercept : interceptors) {
                builder.addInterceptor(intercept);
            }
        }
        return builder.build();
    }


    /**
     * 单例模式获取实例
     *
     * @return 单例对象
     */
    public static RetrofitFactory getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitFactory.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitFactory();
                }
            }
        }
        return mInstance;
    }


    /**
     * 创建Api接口，调用此方法之后再去调用具体的后端接口并得到一个Observable<T>对象
     * 然后配合{@link Http#request(Observable, CallBack, LifecycleProvider)}}方法进行请求
     * 操作
     */
    public <T> T create(Class<T> clazz) {
        return mRetrofit.create(clazz);
    }

}
