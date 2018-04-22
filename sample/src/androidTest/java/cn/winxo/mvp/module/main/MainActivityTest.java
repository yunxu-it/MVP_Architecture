package cn.winxo.mvp.module.main;

import android.graphics.drawable.ColorDrawable;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.content.ContextCompat;
import android.view.View;
import cn.winxo.mvp.R;
import cn.winxo.mvp.module.view.MainActivity;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Author: LiXiaolong
 * Date: 2018/2/9
 * Desc:
 */
@RunWith(AndroidJUnit4.class) public class MainActivityTest {

  @Rule public ActivityTestRule activityTestRule = new ActivityTestRule<>(MainActivity.class);

  @Test public void testButton() {
    onView(withId(R.id.toolbar)).check(matches(isDisplayed()));
    onView(withText(R.string.app_name)).check(matches(withParent(withId(R.id.toolbar))));
    onView(withId(R.id.toolbar)).check(matches(withToolbarBackGroundColor()));
  }

  private Matcher<? super View> withToolbarBackGroundColor() {
    return new BoundedMatcher<View, View>(View.class) {
      @Override public boolean matchesSafely(View view) {
        final ColorDrawable buttonColor = (ColorDrawable) view.getBackground();
        return ContextCompat.getColor(activityTestRule.getActivity(), R.color.colorPrimary)
            == buttonColor.getColor();
      }

      @Override public void describeTo(Description description) {
      }
    };
  }

  @Test public void onLoadPresenter() throws Exception {
  }

  @Test public void setLayoutResourceID() throws Exception {
  }

  @Test public void initView() throws Exception {
  }

  @Test public void showLoading() throws Exception {
  }

  @Test public void hideLoading() throws Exception {
  }
}