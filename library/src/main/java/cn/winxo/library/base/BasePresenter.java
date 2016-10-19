package cn.winxo.library.base;

import cn.winxo.library.mvp.IModel;
import cn.winxo.library.mvp.IPresenter;
import cn.winxo.library.mvp.IView;

public abstract class BasePresenter<T extends IView, M extends IModel> implements IPresenter<T> {

    protected static final String TAG = "BasePresenter";
    protected T mView;
    protected M mModel;

    @Override
    public void attachView(T view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    public boolean isViewAttached() {
        return mView != null;
    }

    public T getView() {
        return mView;
    }

    public M getModel() {
        return mModel;
    }

}