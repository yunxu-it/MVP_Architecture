package cn.winxo.library;

import android.app.Application;

import cn.winxo.library.utils.ToastUtils;

/**
 * User: winxo
 * Date: 2016/8/25
 */
public class LibApp extends Application {

    private static LibApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        ToastUtils.init(this);
    }

    public static LibApp getmInstance() {
        return mInstance;
    }
}
