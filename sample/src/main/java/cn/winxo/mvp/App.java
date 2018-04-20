package cn.winxo.mvp;

import android.app.Application;
import cn.winxo.mvp.util.Toasts;

/**
 * Author: Winxo
 * Date: 2018/2/9
 * Desc:
 */
public class App extends Application {

  @Override public void onCreate() {
    super.onCreate();
    Toasts.register(this);
  }
}
