package cn.winxo.mvp.mvp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;

import com.litocloud.metapos.constant.AppConfig;
import com.litocloud.metapos.utils.rx.RxBus;
import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Global: winxo
 * Date: 2016/8/25
 */
public abstract class BaseActivity extends FragmentActivity {
    private static final String TAG = "BaseActivity";
    private Unbinder mUnbinder;
    public Context mContext;
    private Subscription mSubscription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);
        mSubscription = RxBus.getDefault().toObservable(Object.class).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Object>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Logger.wtf(e.getMessage());
            }

            @Override
            public void onNext(Object o) {
                handleRxMsg(o);
            }
        });
        setContentView(setLayoutResourceID());
        initLate(savedInstanceState);
        mContext = this;
        initPresenter();
        mUnbinder = ButterKnife.bind(this);//绑定ButterKnife

        setUpView();
        setUpData();
    }


    protected void handleRxMsg(Object object) {
    }


    protected void init(Bundle savedInstanceState) {
    }

    protected abstract int setLayoutResourceID();

    protected void initLate(Bundle savedInstanceState) {

    }

    protected void initPresenter() {

    }

    protected abstract void setUpView();

    protected void setUpData() {

    }

    protected <T extends View> T $(int id) {
        return (T) super.findViewById(id);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (AppConfig.DEBUG) {
            Log.i(TAG, "Activity onDestroy " + getClass().getName());
        }
        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
        if (mUnbinder != null) {//解绑ButterKnife
            mUnbinder.unbind();
        }
    }

}
