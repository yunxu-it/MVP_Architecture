package cn.winxo.toolbox.base.ibase;

/**
 * @author lxlong
 * @date 22/04/2018
 * @desc
 */
public interface IPresenter<T extends IView> {

  void attachView(T view);

  void detachView();

  /**
   * RxJava取消注册，以避免内存泄露
   */
  void onUnSubscribe();
}