package cn.winxo.mvp.mvp.interfaces;

public interface IPresenter<T extends IView> {

    void attachView(T view);

    void start();

    void detachView();
}