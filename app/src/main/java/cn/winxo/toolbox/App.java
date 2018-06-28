package cn.winxo.toolbox;

import android.app.Application;
import cn.winxo.toolbox.util.Toasts;

/**
 * @author lxlong
 * @date 22/04/2018
 * @desc
 */
public class App extends Application {

  @Override public void onCreate() {
    super.onCreate();
    Toasts.register(this);
  }
}
