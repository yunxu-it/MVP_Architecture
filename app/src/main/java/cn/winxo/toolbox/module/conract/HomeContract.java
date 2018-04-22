package cn.winxo.toolbox.module.conract;

import cn.winxo.toolbox.base.ibase.IPresenter;
import cn.winxo.toolbox.base.ibase.IView;

public interface HomeContract {

  interface View extends IView {

  }

  interface Presenter extends IPresenter<View> {

  }
}