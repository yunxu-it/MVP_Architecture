package cn.winxo.mvp.module.main;

import cn.winxo.library.base.ibase.IModel;
import cn.winxo.library.base.ibase.IPresenter;
import cn.winxo.library.base.ibase.IView;

/**
 * User: winxo
 * Date: 2018/2/8
 * Time: 18:14
 * Email: yunxu.it@outlook.com
 * Desc:
 */
public interface MainContract {
  interface View extends IView {

    void changeButton(String text);
  }

  interface Model extends IModel {

  }

  interface Presenter extends IPresenter<View> {

    void changeText(int visibility);
  }
}