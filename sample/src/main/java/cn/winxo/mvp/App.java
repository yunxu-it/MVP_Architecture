package cn.winxo.mvp;


import android.app.Application;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

import cn.winxo.mvp.constant.Constants;
import cn.winxo.mvp.utils.ToastUtils;

/**
 * @author dell
 * @date 2016/8/11 10:59
 */
public class App extends Application {

    private static App mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;

        ToastUtils.init(this);

        Logger.init("MetaPos")
                .methodCount(3)
                .logLevel(Constants.DEBUG ? LogLevel.FULL : LogLevel.NONE);

    }

    public static App getInstance() {
        return mInstance;
    }
}
