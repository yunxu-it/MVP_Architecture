package cn.winxo.mvp.mvp.base;


import com.litocloud.metapos.mvp.interfaces.IPresenter;
import com.litocloud.metapos.mvp.interfaces.IView;

/**
 * Global: winxo
 * Date: 2016/8/25
 */
public abstract class BaseMvpActivity<P extends IPresenter> extends BaseActivity implements IView {

    protected P mPresenter;

    protected abstract P onLoadPresenter();

    public P getPresenter() {
        return mPresenter;
    }

    @Override
    protected void initPresenter() {
        super.initPresenter();
        mPresenter = onLoadPresenter();
        getPresenter().attachView(this);
//        if (getPresenter() != null) {
//            getPresenter().start();
//        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (getPresenter() != null) {
            getPresenter().detachView();
        }
    }
}
