package cn.winxo.library.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import cn.winxo.library.rx.RxBus;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * Author: Winxo
 * Date: 2018/2/9
 * Desc:
 */
public abstract class BaseActivity extends AppCompatActivity {
  public Context mContext;
  private Disposable busDisposable;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    init(savedInstanceState);
    busDisposable = RxBus.getDefault()
        .toObservable(Object.class)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(this::handleRxMsg, Throwable::printStackTrace);
    setContentView(setLayoutResourceID());
    initLate(savedInstanceState);
    mContext = this;
    initPresenter();

    initView();
    initData();
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

  protected abstract void initView();

  protected void initData() {

  }

  @Override protected void onDestroy() {
    super.onDestroy();
    RxBus.getDefault().unregister(busDisposable);
  }
}
