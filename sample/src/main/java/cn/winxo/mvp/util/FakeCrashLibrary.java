package cn.winxo.mvp.util;

import android.util.Log;

public final class FakeCrashLibrary {
  public static void log(int priority, String tag, String message) {
    if (priority <= Log.INFO) {
      Log.wtf(tag, message);
    }
  }

  public static void logWarning(Throwable t) {
  }

  public static void logError(Throwable t) {
  }

  private FakeCrashLibrary() {
    throw new AssertionError("No instances.");
  }
}