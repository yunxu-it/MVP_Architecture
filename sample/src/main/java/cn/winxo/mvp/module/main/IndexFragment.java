package cn.winxo.mvp.module.main;

import cn.winxo.mvp.mvp.base.BaseMvpFragment;
import cn.winxo.mvp.R;
import cn.winxo.mvp.module.example.ExamplePresenter;

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
