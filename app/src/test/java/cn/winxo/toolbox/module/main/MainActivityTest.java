package cn.winxo.toolbox.module.main;

import cn.winxo.toolbox.BuildConfig;
import cn.winxo.toolbox.R;
import cn.winxo.toolbox.module.view.MainActivity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

/**
 * Author: Winxo
 * Date: 2018/2/9
 * Desc:
 */
@RunWith(RobolectricTestRunner.class) @Config(constants = BuildConfig.class, sdk = 21)
public class MainActivityTest {

  @Test public void testMainActivity() {
    MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);
    mainActivity.findViewById(R.id.button).performClick();

    ShadowActivity shadowActivity = Shadows.shadowOf(mainActivity);
    //shadowActivity.
  }
}