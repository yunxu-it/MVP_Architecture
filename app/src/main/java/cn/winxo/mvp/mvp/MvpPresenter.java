package cn.winxo.mvp.mvp;

import android.content.Context;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import cn.winxo.mvp.base.BaseView;

/**
 * @author dell
 * @date 2016/8/11 10:30
 */
public class MvpPresenter<M extends MvpModel, V extends BaseView> {

    public Context mContext;
    public Reference<V> mViewRef;
    public M mModel;

    public void initPresenter(V view) {
        mModel = (M) Mvp.getInstance().getModel(Mvp.getGenericType(this, 0));

        mViewRef = new WeakReference<V>(view);
        mContext = Mvp.getInstance().getApplicationContext();
    }

    public V getView() {
        return mViewRef.get();
    }

    public void destory() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
