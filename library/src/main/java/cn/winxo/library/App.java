package cn.winxo.library;

import android.app.Application;

import cn.winxo.library.utils.ToastUtils;

/**
 * User: winxo
 * Date: 2016/8/25
 */
public class App extends Application {

    private static App mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        ToastUtils.init(this);
    }

    public static App getmInstance() {
        return mInstance;
    }
}
