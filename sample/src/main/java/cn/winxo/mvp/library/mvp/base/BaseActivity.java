package cn.winxo.mvp.library.mvp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.winxo.mvp.library.rx.RxBus;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * Global: winxo
 * Date: 2016/8/25
 */
public abstract class BaseActivity extends AppCompatActivity {
  private Unbinder mUnbinder;
  public Context mContext;
  private Disposable mDisposable;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    init(savedInstanceState);

    mDisposable = RxBus.getDefault()
        .toObservable(Object.class)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(this::handleRxMsg, Throwable::printStackTrace);
    setContentView(setLayoutResourceID());
    initLate(savedInstanceState);
    mContext = this;
    initPresenter();
    mUnbinder = ButterKnife.bind(this);//绑定ButterKnife

    setUpView();
    setUpData();
  }

  protected void handleRxMsg(Object object) {
  }

  protected void init(Bundle savedInstanceState) {
  }

  protected abstract int setLayoutResourceID();

  protected void initLate(Bundle savedInstanceState) {

  }

  protected void initPresenter() {

  }

  protected abstract void setUpView();

  protected void setUpData() {

  }

  @Override protected void onDestroy() {
    super.onDestroy();
    RxBus.getDefault().unregister(mDisposable);
    if (mUnbinder != null) {//解绑ButterKnife
      mUnbinder.unbind();
    }
  }
}
