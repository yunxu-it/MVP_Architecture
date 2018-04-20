package cn.winxo.mvp.base;

import cn.winxo.mvp.base.ibase.IModel;
import cn.winxo.mvp.base.ibase.IPresenter;
import cn.winxo.mvp.base.ibase.IView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<V extends IView, M extends IModel> implements IPresenter<V> {

  protected V mView;
  protected M mModel;
  private CompositeDisposable mDisposable;

  @Override public void attachView(V view) {
    mView = view;
    mDisposable = new CompositeDisposable();
  }

  @Override public void detachView() {
    mView = null;
  }

  @Override public void onUnSubscribe() {
    if (mDisposable != null && mDisposable.isDisposed()) {
      mDisposable.clear();
      mDisposable = null;
    }
  }

  public void addSubscription(Disposable disposable) {
    if (mDisposable == null) {
      mDisposable = new CompositeDisposable();
    }
    mDisposable.add(disposable);
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