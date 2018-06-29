package cn.winxo.toolbox.module.view;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import cn.winxo.toolbox.R;
import cn.winxo.toolbox.adapter.HomeTabAdapter;
import cn.winxo.toolbox.base.BaseActivity;

public class TabActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

  private BottomNavigationView mTabs;
  private ViewPager mViewpager;

  @Override protected int setLayoutResourceID() {
    return R.layout.activity_main;
  }

  @Override protected void initView() {
    mViewpager = findViewById(R.id.viewpager);
    mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

      }

      @Override public void onPageSelected(int position) {
        mTabs.setSelectedItemId(position);
      }

      @Override public void onPageScrollStateChanged(int state) {

      }
    });
    mViewpager.setAdapter(new HomeTabAdapter(getSupportFragmentManager()));
    mTabs = findViewById(R.id.tabs);
    mTabs.setOnNavigationItemSelectedListener(this);
  }

  @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    switch (item.getItemId()) {
      case R.id.tab_home:
        mViewpager.setCurrentItem(0);
        break;
      case R.id.tab_mine:
        mViewpager.setCurrentItem(1);
        break;
    }
    return true;
  }
}
