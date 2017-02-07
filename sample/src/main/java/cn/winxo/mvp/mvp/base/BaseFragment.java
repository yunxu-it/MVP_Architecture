package cn.winxo.mvp.mvp.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.winxo.mvp.utils.RxBus;


/**
 * Created by yunxu
 * Date: 2016/8/26.
 * Time：0:13
 */
public abstract class BaseFragment extends Fragment {
    private static final String TAG = "BaseMvpFragment";
    private Unbinder mUnbinder;

    private View mContentView;
    private Context mContext;
    private ProgressDialog mProgressDialog;
    private Subscription mSubscription;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mContentView == null) {
            mContentView = inflater.inflate(setLayoutResourceID(), container, false);
        }
        initPresenter();
        mUnbinder = ButterKnife.bind(this, mContentView);

        mContext = getContext();
        mProgressDialog = new ProgressDialog(getMContext());
        mProgressDialog.setCanceledOnTouchOutside(false);

        mSubscription = RxBus.getDefault().toObservable(Object.class).subscribe(new Subscriber<Object>() {

            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(Object o) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });



        init(savedInstanceState);
        setUpView();
        setUpData();
        return mContentView;
    }

    protected void handleRxMsg(Object object) {

    }

    protected abstract int setLayoutResourceID();

    protected void initPresenter() {

    }

    /**
     * initialize before  setUpView and  setUpData
     */
    protected void init(Bundle savedInstanceState) {
    }

    protected abstract void setUpView();

    protected abstract void setUpData();

    protected <T extends View> T $(int id) {
        return (T) mContentView.findViewById(id);
    }

    protected void startActivityWithoutExtras(Class<?> clazz) {
        Intent intent = new Intent(mContext, clazz);
        startActivity(intent);
    }

    protected View getContentView() {
        return mContentView;
    }

    public Context getMContext() {
        return mContext;
    }

    protected ProgressDialog getProgressDialog() {
        return mProgressDialog;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null) {//解绑ButterKnife
            mUnbinder.unbind();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }
}
