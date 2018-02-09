package cn.winxo.library.base;

import android.widget.Toast;

/**
 * Author: Winxo
 * Date: 2016/8/25
 * Desc:
 */
public abstract class BaseMainActivity extends BaseActivity {
  private long lastBackKeyDownTick = 0;
  private static final long MAX_DOUBLE_BACK_DURATION = 1500;

  @Override public void onBackPressed() {
    beforeOnBackPressed();
    long currentTick = System.currentTimeMillis();
    if (currentTick - lastBackKeyDownTick > MAX_DOUBLE_BACK_DURATION) {
      Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
      lastBackKeyDownTick = currentTick;
    } else {
      finish();
      System.exit(0);
    }
  }

  protected void beforeOnBackPressed() {

  }
}
