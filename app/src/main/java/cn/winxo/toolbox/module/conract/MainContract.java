package cn.winxo.toolbox.module.conract;

import cn.winxo.toolbox.base.ibase.IPresenter;
import cn.winxo.toolbox.base.ibase.IView;

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

  interface Presenter extends IPresenter<View> {

    void changeText(int visibility);
  }
}