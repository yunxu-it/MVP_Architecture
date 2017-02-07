package cn.winxo.mvp.mvp.base;

import cn.winxo.mvp.mvp.interfaces.IModel;
import cn.winxo.mvp.mvp.interfaces.IPresenter;
import cn.winxo.mvp.mvp.interfaces.IView;

public abstract class BasePresenter<V extends IView, M extends IModel> implements IPresenter<V> {

    protected V mView;
    protected M mModel;

    @Override
    public void attachView(V view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    public boolean isViewAttached() {
        return mView != null;
    }

    public V getView() {
        return mView;
    }

    public M getModel() {
        return mModel;
    }

}