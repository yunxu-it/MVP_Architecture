package cn.winxo.mvp.mvp.interfaces;

/**
 * Created by yunxu
 * Date: 2016/10/10.
 * Time：1:10
 */

public interface IView {
    void showLoading();

    void hideLoading();

    void showError(String s);
}
