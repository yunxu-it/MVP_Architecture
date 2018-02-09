package cn.winxo.mvp.module.main;

import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import cn.winxo.library.base.BaseMvpActivity;
import cn.winxo.mvp.R;

public class MainActivity extends BaseMvpActivity<MainContract.Presenter>
    implements MainContract.View {

  protected Toolbar mToolbar;
  protected AppBarLayout mAppbar;
  protected Button mButton;
  //protected FrameLayout mFrameContent;

  @Override protected MainContract.Presenter onLoadPresenter() {
    return new MainPresenter(this);
  }

  @Override protected int setLayoutResourceID() {
    return R.layout.activity_main;
  }

  @Override protected void initView() {
    mToolbar = (Toolbar) findViewById(R.id.toolbar);
    mAppbar = (AppBarLayout) findViewById(R.id.appbar);
    mButton = (Button) findViewById(R.id.button);
    //mFrameContent = (FrameLayout) findViewById(R.id.frame_content);

    mToolbar.setTitle(R.string.app_name);
  }

  @Override public void showLoading() {

  }

  @Override public void hideLoading() {

  }
}
