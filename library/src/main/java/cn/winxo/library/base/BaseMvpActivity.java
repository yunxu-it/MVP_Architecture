package cn.winxo.library.base;

import android.text.TextUtils;
import cn.winxo.library.base.ibase.IPresenter;
import cn.winxo.library.base.ibase.IView;
import cn.winxo.library.util.Toasts;

/**
 * Author: Winxo
 * Date: 2018/2/9
 * Desc:
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
      getPresenter().onUnSubscribe();
    }
    if (getPresenter() != null) {
      getPresenter().detachView();
    }
  }
}
