package cn.winxo.mvp.module.view;

import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import cn.winxo.mvp.R;
import cn.winxo.mvp.base.BaseMvpActivity;
import cn.winxo.mvp.module.conract.MainContract;
import cn.winxo.mvp.module.presenter.MainPresenter;

public class MainActivity extends BaseMvpActivity<MainContract.Presenter>
    implements MainContract.View {

  protected Toolbar mToolbar;
  protected AppBarLayout mAppbar;
  protected Button mButton;

  @Override protected MainContract.Presenter onLoadPresenter() {
    return new MainPresenter(this);
  }

  @Override protected int setLayoutResourceID() {
    return R.layout.activity_main;
  }

  @Override protected void initView() {
    mToolbar = findViewById(R.id.toolbar);
    mAppbar = findViewById(R.id.appbar);
    mButton = findViewById(R.id.button);
    //mFrameContent = (FrameLayout) findViewById(R.id.frame_content);

    mToolbar.setTitle(R.string.app_name);
    mButton.setOnClickListener(view -> {
      mToolbar.setVisibility(
          mToolbar.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
      mPresenter.changeText(mToolbar.getVisibility());
    });
  }

  @Override public void changeButton(String text) {
    mButton.setText(text);
  }
}
