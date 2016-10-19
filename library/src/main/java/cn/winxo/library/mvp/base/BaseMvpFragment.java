package cn.winxo.library.mvp.base;

import cn.winxo.library.base.BaseFragment;
import cn.winxo.library.mvp.IPresenter;
import cn.winxo.library.mvp.IView;

/**
 * Created by yunxu
 * Date: 2016/8/26.
 * Time：0:13
 */
public abstract class BaseMvpFragment<P extends IPresenter> extends BaseFragment implements IView {

    protected P mPresenter;

    @Override
    protected void initPresenter() {
        super.initPresenter();
        mPresenter = onLoadPresenter();
        getPresenter().attachView(this);
        if (getPresenter() != null) {
            getPresenter().start();
        }
    }

    protected abstract P onLoadPresenter();

    public P getPresenter() {
        return mPresenter;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (getPresenter() != null) {
            getPresenter().detachView();
        }
    }
}
