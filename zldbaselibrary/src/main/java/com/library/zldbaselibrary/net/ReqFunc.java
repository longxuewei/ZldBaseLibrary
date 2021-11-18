package com.library.zldbaselibrary.net;

import com.library.zldbaselibrary.exception.EmptyDataException;
import com.library.zldbaselibrary.exception.ReqException;
import com.library.zldbaselibrary.net.resp.BaseResp;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;

/**
 * 作者：Lxw
 * 时间：2021-11-13 11:30
 * <p>
 * 注释：请求转换器，当得到请求结果之后，会将请求结果转换至对象，并且这里会通过状态码进行判断业务逻辑是否成功，如果失败则抛出异常。
 */
public class ReqFunc<T> implements Function<BaseResp<T>, Observable<T>> {

    @Override
    public Observable<T> apply(BaseResp<T> resp) {
        if (!resp.isSuccess()) {
            return Observable.error(new ReqException(resp.getStatus(), resp.getMsg()));
        }

        T data = resp.getData();
        if (data != null) {
            return Observable.just(data);
        } else {
            return Observable.error(new EmptyDataException(resp.getStatus(), resp.getMsg()));
        }
    }
}
