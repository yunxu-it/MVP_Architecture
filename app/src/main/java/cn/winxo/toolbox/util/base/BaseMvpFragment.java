package cn.winxo.toolbox.util.base;

import cn.winxo.toolbox.util.base.ibase.IPresenter;
import cn.winxo.toolbox.util.base.ibase.IView;

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

  @Override public void onDestroy() {
    super.onDestroy();
    if (getPresenter() != null) {
      getPresenter().detachView();
    }
  }
}
