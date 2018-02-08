package cn.winxo.mvp.library.mvp.base;

import android.text.TextUtils;
import cn.winxo.library.util.Toasts;
import cn.winxo.mvp.library.mvp.ibase.IPresenter;
import cn.winxo.mvp.library.mvp.ibase.IView;

/**
 * Global: winxo
 * Date: 2016/8/25
 */
public abstract class BaseMvpActivity<P extends IPresenter> extends BaseActivity implements IView {

  protected P mPresenter;

  protected abstract P onLoadPresenter();

  public P getPresenter() {
    return mPresenter;
  }

  @Override protected void initPresenter() {
    super.initPresenter();
    mPresenter = onLoadPresenter();
    getPresenter().attachView(this);
  }

  @Override public void showError(Throwable throwable) {
    if (throwable != null && !TextUtils.isEmpty(throwable.getMessage())) {
      Toasts.showShort(throwable.getMessage());
    }
  }

  @Override protected void onResume() {
    super.onResume();
    getPresenter().attachView(this);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    if (getPresenter() != null) {
      getPresenter().onUnsubscribe();
    }
    if (getPresenter() != null) {
      getPresenter().detachView();
    }
  }
}
