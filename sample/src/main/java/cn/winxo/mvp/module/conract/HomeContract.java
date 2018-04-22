package cn.winxo.mvp.module.conract;

import cn.winxo.mvp.base.ibase.IPresenter;
import cn.winxo.mvp.base.ibase.IView;

public interface HomeContract {

  interface View extends IView {

  }

  interface Presenter extends IPresenter<View> {

  }
}