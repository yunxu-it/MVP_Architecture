package cn.winxo.mvp.module.main;

import cn.winxo.mvp.library.mvp.ibase.IModel;
import cn.winxo.mvp.library.mvp.ibase.IPresenter;
import cn.winxo.mvp.library.mvp.ibase.IView;

/**
 * User: winxo
 * Date: 2018/2/8
 * Time: 18:14
 * Email: yunxu.it@outlook.com
 * Desc:
 */
public interface MainContract {
  interface View extends IView {

  }

  interface Model extends IModel {

  }

  interface Presenter extends IPresenter<View> {

  }
}