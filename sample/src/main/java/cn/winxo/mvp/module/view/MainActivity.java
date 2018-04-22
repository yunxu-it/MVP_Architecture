package cn.winxo.mvp.module.view;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.Toolbar;
import cn.winxo.mvp.R;
import cn.winxo.mvp.base.BaseMvpActivity;
import cn.winxo.mvp.module.conract.MainContract.Presenter;
import cn.winxo.mvp.module.conract.MainContract.View;
import cn.winxo.mvp.module.presenter.MainPresenter;

public class MainActivity extends BaseMvpActivity<Presenter> implements View {

  protected Toolbar mToolbar;
  private BottomNavigationView mTabs;

  @Override protected Presenter onLoadPresenter() {
    return new MainPresenter(this);
  }

  @Override protected int setLayoutResourceID() {
    return R.layout.activity_main;
  }

  @Override protected void initView() {
    mToolbar = findViewById(R.id.toolbar);
    mToolbar.setTitle(R.string.app_name);
    mTabs = findViewById(R.id.tabs);
    mTabs.setOnNavigationItemSelectedListener(item -> {
      mToolbar.setTitle(item.getTitle().toString().toUpperCase());
      return true;
    });
  }

  @Override public void changeButton(String text) {

  }
}
