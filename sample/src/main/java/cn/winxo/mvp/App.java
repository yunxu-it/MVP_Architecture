package cn.winxo.mvp;

import cn.winxo.library.LibApp;
import cn.winxo.mvp.util.FakeCrashLibrary;
import java.util.Locale;
import timber.log.Timber;

/**
 * Author: Winxo
 * Date: 2018/2/9
 * Desc:
 */
public class App extends LibApp {

  @Override public void onCreate() {
    super.onCreate();
    initTimber();
  }

  private void initTimber() {
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree() {
        @Override protected String createStackElementTag(StackTraceElement element) {
          return String.format(Locale.CHINA, "%s:%s:%d", super.createStackElementTag(element),
              element.getMethodName(), element.getLineNumber());
        }
      });
    } else {
      Timber.plant(new Timber.Tree() {
        @Override protected void log(int priority, String tag, String message, Throwable t) {
          FakeCrashLibrary.log(priority, tag, message);
        }
      });
    }
  }
}
