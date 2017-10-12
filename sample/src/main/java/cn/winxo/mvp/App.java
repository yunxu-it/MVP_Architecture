package cn.winxo.mvp;

import android.app.Application;
import cn.winxo.mvp.library.util.Toasts;

/**
 * @author dell
 * @date 2016/8/11 10:59
 */
public class App extends Application {

  @Override public void onCreate() {
    super.onCreate();

    Toasts.register(this);
  }

  //private void initTimber() {
  //    if (BuildConfig.DEBUG) {
  //        Timber.plant(new Timber.DebugTree() {
  //            @Override protected String createStackElementTag(StackTraceElement element) {
  //                return String.format(Locale.CHINA, "%s:%s:%d", super.createStackElementTag(element),
  //                    element.getMethodName(), element.getLineNumber());
  //            }
  //        });
  //    } else {
  //        Timber.plant(new CrashReportingTree());
  //    }
  //}
}
