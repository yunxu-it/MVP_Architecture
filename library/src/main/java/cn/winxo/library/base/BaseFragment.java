package cn.winxo.library.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.winxo.library.rx.RxBus;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by yunxu
 * Date: 2016/8/26.
 * Time：0:13
 */
public abstract class BaseFragment extends Fragment {


    private View mContentView;
    private Context mContext;
    private ProgressDialog mProgressDialog;
    private Subscription mSubscription;
    private Unbinder mUnbinder;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mContentView == null) {
            mContentView = inflater.inflate(setLayoutResourceID(), container, false);
            mUnbinder = ButterKnife.bind(this, mContentView);
        }
        initPresenter();
        mContext = getContext();
        mProgressDialog = new ProgressDialog(getMContext());
        mProgressDialog.setCanceledOnTouchOutside(false);

        mSubscription = RxBus.getInstance().tObservable(String.class).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                handleRxMsg(s);
            }
        });
        init();
        setUpView();
        setUpData();
        return mContentView;
    }

    protected void handleRxMsg(String msg) {

    }


    protected abstract int setLayoutResourceID();

    protected void initPresenter() {

    }

    /**
     * initialize before  setUpView and  setUpData
     */
    protected void init() {

    }

    protected abstract void setUpView();

    protected abstract void setUpData();

    protected <T extends View> T $(int id) {
        return (T) mContentView.findViewById(id);
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
        mUnbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mSubscription != null && mSubscription.isUnsubscribed())
            mSubscription.unsubscribe();
    }
}
