package cn.winxo.library.mvp.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.winxo.library.mvp.IPresenter;
import cn.winxo.library.mvp.IView;
import cn.winxo.library.rx.RxBus;
import rx.Subscription;
import rx.functions.Action1;

/**
 * User: winxo
 * Date: 2016/8/25
 */
public abstract class BaseMvpActivity<P extends IPresenter> extends AppCompatActivity implements IView {

    private Subscription mSubscription;
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSubscription = RxBus.getInstance().tObservable(String.class).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                handleRxMsg(s);
            }
        });

        init(savedInstanceState);
        setContentView(setLayoutResourceID());
        setUpView();
        mPresenter = onLoadPresenter();
        getPresenter().attachView(this);
        if (getPresenter() != null) {
            getPresenter().start();
        }
        setUpData();
    }

    protected abstract P onLoadPresenter();

    public P getPresenter() {
        return mPresenter;
    }

    protected void handleRxMsg(String msg) {

    }


    protected void setUpData() {

    }

    protected void init(Bundle savedInstanceState) {

    }

    protected abstract void setUpView();

    protected abstract int setLayoutResourceID();


    protected <T extends View> T $(int id) {
        return (T) super.findViewById(id);
    }

    protected void startActivityWithoutExtras(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    protected void startActivityWithExtras(Class<?> clazz, Bundle extras) {
        Intent intent = new Intent(this, clazz);
        intent.putExtras(extras);
        startActivity(intent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (getPresenter() != null) {
            getPresenter().detachView();
        }
        mSubscription.unsubscribe();
    }
}
