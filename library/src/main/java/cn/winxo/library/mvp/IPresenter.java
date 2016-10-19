package cn.winxo.library.mvp;

public interface IPresenter<T extends IView> {

    void attachView(T view);

    void start();

    void detachView();
}