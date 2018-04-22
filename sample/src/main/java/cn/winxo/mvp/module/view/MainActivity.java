package cn.winxo.mvp.module.view;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import cn.winxo.mvp.R;
import cn.winxo.mvp.adapter.HomeTabAdapter;
import cn.winxo.mvp.base.BaseMvpActivity;
import cn.winxo.mvp.module.conract.MainContract.Presenter;
import cn.winxo.mvp.module.conract.MainContract.View;
import cn.winxo.mvp.module.presenter.MainPresenter;

public class MainActivity extends BaseMvpActivity<Presenter>
    implements View, BottomNavigationView.OnNavigationItemSelectedListener {

  protected Toolbar mToolbar;
  private BottomNavigationView mTabs;
  private ViewPager mViewpager;

  @Override protected Presenter onLoadPresenter() {
    return new MainPresenter(this);
  }

  @Override protected int setLayoutResourceID() {
    return R.layout.activity_main;
  }

  @Override protected void initView() {
    mToolbar = findViewById(R.id.toolbar);
    mToolbar.setTitle(R.string.app_name);
    mViewpager = findViewById(R.id.viewpager);
    mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

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

  @Override public void changeButton(String text) {

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
