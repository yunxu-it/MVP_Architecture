package cn.winxo.mvp.library.mvp.base;

import android.text.TextUtils;
import cn.winxo.mvp.library.mvp.ibase.IPresenter;
import cn.winxo.mvp.library.mvp.ibase.IView;
import cn.winxo.mvp.library.util.Toasts;

/**
 * Created by yunxu
 * Date: 2016/8/26.
 * Time：0:13
 */
public abstract class BaseMvpFragment<P extends IPresenter> extends BaseFragment implements IView {

  protected P mPresenter;

  @Override protected void initPresenter() {
    super.initPresenter();
    mPresenter = onLoadPresenter();
    getPresenter().attachView(this);
    //        if (getPresenter() != null) {
    //            getPresenter().start();
    //        }
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
