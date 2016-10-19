package cn.winxo.library.mvp;

public interface IListener<T> {
    void onSuccess(T data);

    void onError(String s);
}