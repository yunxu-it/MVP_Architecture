package cn.winxo.library.base.ibase;

public interface IPresenter<T extends IView> {

  void attachView(T view);

  void detachView();

  /**
   * RxJava取消注册，以避免内存泄露
   */
  void onUnSubscribe();
}