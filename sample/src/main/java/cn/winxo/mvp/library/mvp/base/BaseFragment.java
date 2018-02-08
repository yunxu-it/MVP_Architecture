package cn.winxo.mvp.library.mvp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.BuildConfig;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.winxo.mvp.library.rx.RxBus;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * Created by yunxu
 * Date: 2016/8/26.
 * Time：0:13
 */
public abstract class BaseFragment extends Fragment {
  private static final String TAG = "BaseMvpFragment";

  private View mContentView;
  private Context mContext;
  private Disposable mDisposable;

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    if (BuildConfig.DEBUG) {
      Log.e(TAG, "onCreate View Fragment:" + getClass().getName());
    }
    if (mContentView == null) {
      mContentView = inflater.inflate(setLayoutResourceID(), container, false);
    }
    initPresenter();

    mContext = getContext();

    mDisposable = RxBus.getDefault()
        .toObservable(Object.class)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(this::handleRxMsg,
            throwable -> Log.wtf("RxBus Error: ", throwable.getMessage()));
    init(savedInstanceState);
    setUpView();
    setUpData();
    return mContentView;
  }

  protected void handleRxMsg(Object object) {

  }

  protected abstract int setLayoutResourceID();

  protected void initPresenter() {

  }

  /**
   * initialize before  setUpView and  setUpData
   */
  protected void init(Bundle savedInstanceState) {
  }

  protected abstract void setUpView();

  protected abstract void setUpData();

  @Override public void onDestroy() {
    super.onDestroy();
    RxBus.getDefault().unregister(mDisposable);
  }
}
