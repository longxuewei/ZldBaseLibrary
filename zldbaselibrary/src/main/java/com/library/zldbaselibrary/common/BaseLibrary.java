package com.library.zldbaselibrary.common;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.library.zldbaselibrary.config.BaseLibraryConfig;
import com.library.zldbaselibrary.config.NetWorkConfig;

import java.util.List;

/**
 * 作者：Lxw
 * 时间：2021-11-11 18:21
 * <p>
 * 注释：
 */
public class BaseLibrary {

    @SuppressLint("StaticFieldLeak")
    private static BaseLibrary mInstance;

    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    /** 基础配置 */
    private static NetWorkConfig mNetWorkConfig;


    private BaseLibrary() {

    }


    public static BaseLibrary getInstance() {
        if (mInstance == null) {
            synchronized (BaseLibrary.class) {
                if (mInstance == null) {
                    mInstance = new BaseLibrary();
                }
            }
        }
        return mInstance;
    }

    /**
     * 请在自己的 Application 中进行初始化，并传入对应的配置。配置包含各种配置例如：网络配置
     *
     * @param context Application 上下文
     * @param config  基础库的配置
     */
    public static void init(Application context, List<BaseLibraryConfig> config) {
        mContext = context;
        for (BaseLibraryConfig baseLibraryConfig : config) {
            if (baseLibraryConfig instanceof NetWorkConfig) {
                mNetWorkConfig = (NetWorkConfig) baseLibraryConfig;
            }
        }
    }

    /**
     * 给基础库暴露方法获取Context
     *
     * @return App全局上下文
     */
    public Context getContext() {
        return mContext;
    }


    /**
     * 给基础库暴露方法获取网络配置，让基础库能够初始化Retrofit/Okhttp等相关的参数
     *
     * @return 网络配置实例
     */
    public NetWorkConfig getNetWorkConfig() {
        return mNetWorkConfig;
    }
}
