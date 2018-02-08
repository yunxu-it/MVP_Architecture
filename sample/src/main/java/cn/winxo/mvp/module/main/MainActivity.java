package cn.winxo.mvp.module.main;

import cn.winxo.mvp.R;
import cn.winxo.mvp.library.mvp.base.BaseMvpActivity;

public class MainActivity extends BaseMvpActivity<MainContract.Presenter>
    implements MainContract.View {

  @Override protected MainContract.Presenter onLoadPresenter() {
    return new MainPresenter(this);
  }

  @Override protected int setLayoutResourceID() {
    return R.layout.activity_main;
  }

  @Override protected void setUpView() {

  }

  @Override public void showLoading() {

  }

  @Override public void hideLoading() {

  }
}
