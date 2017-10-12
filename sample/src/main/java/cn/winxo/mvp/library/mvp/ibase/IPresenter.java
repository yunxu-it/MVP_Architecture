package cn.winxo.mvp.library.mvp.ibase;

public interface IPresenter<T extends IView> {

  void attachView(T view);

  void detachView();

  //RXjava取消注册，以避免内存泄露
  void onUnsubscribe();
}