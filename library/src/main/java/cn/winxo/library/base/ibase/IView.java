package cn.winxo.library.base.ibase;

/**
 * Author: Winxo
 * Date: 2016/10/10
 * Desc:
 */
public interface IView {
  void showLoading();

  void hideLoading();

  void showError(Throwable throwable);
}
