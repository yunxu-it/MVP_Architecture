package cn.winxo.mvp.ui.fragment;

import cn.winxo.library.mvp.base.BaseMvpFragment;
import cn.winxo.mvp.R;
import cn.winxo.mvp.presenter.ExamplePresenter;

/**
 * User: winxo
 * Date: 2016/10/19
 */
public class IndexFragment extends BaseMvpFragment<ExamplePresenter> {

    @Override
    protected ExamplePresenter onLoadPresenter() {
        return new ExamplePresenter(this.getActivity());
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_index;
    }

    @Override
    protected void setUpView() {

    }

    @Override
    protected void setUpData() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String s) {

    }
}
