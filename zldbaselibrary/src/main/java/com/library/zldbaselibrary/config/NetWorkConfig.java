package com.library.zldbaselibrary.config;

import java.util.List;

import okhttp3.Interceptor;

/**
 * 作者：Lxw
 * 时间：2021-11-11 18:08
 * <p>
 * 注释：这是基础库的网络框架初始化配置类，配置了网络请求的相关参数例如：超时时间、BaseUrl、拦截器等；
 */
public class NetWorkConfig implements BaseLibraryConfig {

    /** 基础域名，由于基础库使用了Retrofit来作为网络访问框架，所以在任何网络访问之前请提供此字段 */
    private final String mBaseUrl;

    /** Http读取时间（单位：秒，默认10秒） */
    private int readTimeout = 10;

    /** Http写入时间（单位：秒，默认10秒） */
    private int writeTimeout = 10;

    /** Http连接时间（单位：秒，默认10秒） */
    private int connectTimeout = 10;

    /** Retrofit的拦截器，可以自己定义拦截器来进行响应的数据处理，一般可以用来解密服务器响应的数据（例如AES解密等）；添加HttpLoggingInterceptor拦截器打印日志等 */
    private List<Interceptor> interceptors;

    private NetWorkConfig(Builder builder) {
        this.mBaseUrl = builder.baseUrl;
        this.readTimeout = builder.readTimeout;
        this.writeTimeout = builder.writeTimeout;
        this.connectTimeout = builder.connectTimeout;
        this.interceptors = builder.interceptors;
    }


    public String getBaseUrl() {
        return mBaseUrl;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public int getWriteTimeout() {
        return writeTimeout;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public List<Interceptor> getInterceptors() {
        return interceptors;
    }

    public static class Builder {

        private String baseUrl;
        private int readTimeout = 10;
        private int writeTimeout = 10;
        private int connectTimeout = 10;
        private List<Interceptor> interceptors;


        public Builder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder readTimeout(int readTimeout) {
            this.readTimeout = readTimeout;
            return this;
        }

        public Builder writeTimeout(int writeTimeout) {
            this.writeTimeout = writeTimeout;
            return this;
        }

        public Builder connectTimeout(int connectTimeout) {
            this.connectTimeout = connectTimeout;
            return this;
        }

        public Builder interceptors(List<Interceptor> interceptors) {
            this.interceptors = interceptors;
            return this;
        }

        public NetWorkConfig build() {
            return new NetWorkConfig(this);
        }
    }
}
