package cn.winxo.toolbox.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import cn.winxo.toolbox.util.RxBus;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * @author lxlong
 * @date 22/04/2018
 * @desc
 */
public abstract class BaseActivity extends AppCompatActivity {
  private Disposable busDisposable;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    init(savedInstanceState);
    busDisposable =
        RxBus.getDefault().toObservable(Object.class).observeOn(AndroidSchedulers.mainThread()).subscribe(this::handleRxMsg, Throwable::printStackTrace);
    setContentView(setLayoutResourceID());
    initLate(savedInstanceState);
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
