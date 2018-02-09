package cn.winxo.mvp.module.main;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import cn.winxo.library.base.BaseMvpActivity;
import cn.winxo.mvp.R;
import cn.winxo.mvp.di.AppComponent;
import cn.winxo.mvp.di.AppModule;
import cn.winxo.mvp.di.DaggerAppComponent;
import javax.inject.Inject;

public class MainActivity extends BaseMvpActivity<MainContract.Presenter>
    implements MainContract.View {

  @Inject MainPresenter presenter;

  protected Toolbar mToolbar;
  protected AppBarLayout mAppbar;
  protected Button mButton;
  private AppComponent component;
  //protected FrameLayout mFrameContent;

  @Override protected MainContract.Presenter onLoadPresenter() {
    return new MainPresenter(this);
  }

  @Override protected int setLayoutResourceID() {
    return R.layout.activity_main;
  }

  @Override protected void initLate(Bundle savedInstanceState) {
    super.initLate(savedInstanceState);
    component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    component.inject(this);
  }

  @Override protected void initView() {
    mToolbar = (Toolbar) findViewById(R.id.toolbar);
    mAppbar = (AppBarLayout) findViewById(R.id.appbar);
    mButton = (Button) findViewById(R.id.button);
    //mFrameContent = (FrameLayout) findViewById(R.id.frame_content);

    mToolbar.setTitle(R.string.app_name);
    mButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        mToolbar.setVisibility(
            mToolbar.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
        mPresenter.changeText(mToolbar.getVisibility());
      }
    });
  }

  @Override public void showLoading() {

  }

  @Override public void hideLoading() {

  }

  @Override public void changeButton(String text) {
    mButton.setText(text);
  }
}
