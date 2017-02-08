package cn.winxo.mvp.module.main;

import java.util.List;

import cn.winxo.mvp.api.entity.ResultsModel;
import cn.winxo.mvp.module.example.GankContact;
import cn.winxo.mvp.mvp.base.BaseMvpFragment;
import cn.winxo.mvp.R;
import cn.winxo.mvp.module.example.GankPresenter;

/**
 * User: winxo
 * Date: 2016/10/19
 */
public class IndexFragment extends BaseMvpFragment<GankContact.Presenter> implements GankContact.View {

    @Override
    protected GankPresenter onLoadPresenter() {
        return new GankPresenter(this.getActivity());
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

    @Override
    public void showExample(List<ResultsModel> models) {

    }
}
