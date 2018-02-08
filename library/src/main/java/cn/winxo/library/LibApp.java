package cn.winxo.library;

import android.app.Application;
import cn.winxo.library.util.Toasts;

/**
 * @author yunxu
 * @date 09/02/2018
 * @desc
 */
public class LibApp extends Application {

  @Override public void onCreate() {
    super.onCreate();
    Toasts.register(this);
  }
}
