package cn.winxo.library;

import android.app.Application;
import cn.winxo.library.util.Toasts;

/**
 * Author: Winxo
 * Date: 2018/2/9
 * Desc:
 */
public class LibApp extends Application {

  @Override public void onCreate() {
    super.onCreate();
    Toasts.register(this);
  }
}
