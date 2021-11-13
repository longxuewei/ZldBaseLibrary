package com.library.zldbaselibrary.ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ToastUtils;
import com.kongzue.dialogx.dialogs.CustomDialog;
import com.kongzue.dialogx.interfaces.OnBindView;
import com.library.zldbaselibrary.R;
import com.library.zldbaselibrary.ui.activity.BaseMvpActivity;

/**
 * 基础类型弹框样式，要想自定义，请实现{@link ILoading}接口并复写{@link BaseMvpActivity#initLoading()}函数
 */
public class CommonLoading implements ILoading {


    private CustomDialog mDialog;

    @Override
    public void showLoadingDialog(Context context, @Nullable String msg) {
        mDialog = CustomDialog.build()
                .setCustomView(new OnBindView<CustomDialog>(R.layout.dialog_common) {
                    @Override
                    public void onBind(final CustomDialog dialog, View v) {
                        TextView mMsgTv = v.findViewById(R.id.mMsgTv);
                        if (msg == null || msg.isEmpty()) {
                            mMsgTv.setText(msg);
                        } else {
                            mMsgTv.setVisibility(View.GONE);
                        }
                    }
                });
        mDialog.show();
    }

    @Override
    public void dismissLoadingDialog() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }

    @Override
    public void showMsg(@NonNull String msg) {
        ToastUtils.showShort(msg);
    }
}
