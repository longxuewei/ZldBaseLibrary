package com.library.zldbaselibrary.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 作者：Lxw
 * 时间：2021-11-09 16:18
 * <p>
 * 注释：简单的一个基类，如果页面简单则可以绕过{@link BaseMvpFragment} 直接集成该类。从而实现简单的页面展示
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(layoutId(), container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }


    /**
     * 初始化布局
     *
     * @return 布局ID
     */
    public abstract int layoutId();


    /**
     * 初始化视图
     *
     * @param view 布局View，使用该View进行 findViewById
     */
    public abstract void initView(View view);
}
