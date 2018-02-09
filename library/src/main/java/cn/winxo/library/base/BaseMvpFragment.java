package cn.winxo.library.base;

import android.text.TextUtils;
import cn.winxo.library.base.ibase.IPresenter;
import cn.winxo.library.base.ibase.IView;
import cn.winxo.library.util.Toasts;

/**
 * Author: Winxo
 * Date: 2016/8/26
 * Desc:
 */
public abstract class BaseMvpFragment<P extends IPresenter> extends BaseFragment implements IView {

  protected P mPresenter;

  @Override protected void initPresenter() {
    super.initPresenter();
    mPresenter = onLoadPresenter();
    getPresenter().attachView(this);
  }

  protected abstract P onLoadPresenter();

  public P getPresenter() {
    return mPresenter;
  }

  @Override public void showError(Throwable throwable) {
    if (throwable != null && !TextUtils.isEmpty(throwable.getMessage())) {
      Toasts.showShort(throwable.getMessage());
    }
  }

  @Override public void onDestroy() {
    super.onDestroy();
    if (getPresenter() != null) {
      getPresenter().detachView();
    }
  }
}
