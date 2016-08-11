package cn.winxo.mvp;

import android.app.Application;

import cn.winxo.mvp.mvp.Mvp;

/**
 * @author dell
 * @date 2016/8/11 10:59
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Mvp.getInstance().init(this);
    }
}
