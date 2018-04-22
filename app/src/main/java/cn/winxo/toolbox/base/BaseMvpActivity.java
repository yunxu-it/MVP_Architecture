package cn.winxo.toolbox.base;

import cn.winxo.toolbox.base.ibase.IPresenter;
import cn.winxo.toolbox.base.ibase.IView;

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

  @Override protected void onResume() {
    super.onResume();
    getPresenter().attachView(this);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    if (getPresenter() != null) {
      getPresenter().onUnSubscribe();
      getPresenter().detachView();
    }
  }
}
