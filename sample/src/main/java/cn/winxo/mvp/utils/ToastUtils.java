package cn.winxo.mvp.utils;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import cn.winxo.mvp.R;


public class ToastUtils {

    private static Context mContext;
    private static ToastUtils mInstance;
    private Toast mToast;
    public static final int TYPE_INFO = 0;
    public static final int TYPE_ERROR = 1;

    public static ToastUtils getInstance() {
        return mInstance;
    }

    public static void init(Context ctx) {
        mInstance = new ToastUtils(ctx);
    }

    private ToastUtils(Context ctx) {
        mContext = ctx;
    }

    public void showToast(String message) {
        showToast(message, Toast.LENGTH_SHORT, TYPE_INFO);
    }

    public void showErrorToast(String message) {
        showToast(message, Toast.LENGTH_SHORT, TYPE_ERROR);
    }

    public void showToast(String message, int type) {
        showToast(message, Toast.LENGTH_SHORT, type);
    }

    public void showToast(String massage, int show_length, int type) {
        //使用布局加载器，将编写的toast_layout布局加载进来
        View view = LayoutInflater.from(mContext).inflate(R.layout.bg_toast, null);
        if (type == TYPE_ERROR) {
            view.setBackground(ContextCompat.getDrawable(mContext, R.drawable.bg_red_400_20));
        }
        //获取TextView
        TextView title = (TextView) view.findViewById(R.id.toast_tv);
        //设置显示的内容
        title.setText(massage);
        if (mToast == null) {
            mToast = new Toast(mContext);
        }
        //设置Toast要显示的位置，水平居中并在底部，X轴偏移0个单位，Y轴偏移70个单位，
        mToast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, 70);
        //设置显示时间
        mToast.setDuration(show_length);
        mToast.setView(view);
        mToast.show();
    }


    public void cancelToast() {
        if (mToast != null) {
            mToast.cancel();
        }
    }
}