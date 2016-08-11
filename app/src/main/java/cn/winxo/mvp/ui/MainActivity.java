package cn.winxo.mvp.ui;

import android.os.Bundle;

import java.util.List;

import cn.winxo.mvp.R;
import cn.winxo.mvp.base.BaseView;
import cn.winxo.mvp.contract.ExampleContract;
import cn.winxo.mvp.model.entity.Example;
import cn.winxo.mvp.mvp.MvpActivity;
import cn.winxo.mvp.presenter.ExamplePresenter;

public class MainActivity extends MvpActivity<ExamplePresenter> implements ExampleContract.View {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public BaseView getBaseView() {
        return this;
    }


    private void refresh() {
        mPresenter.getExample();
    }


    @Override
    public void showExample(List<Example> exampleList) {

    }

    @Override
    public void showError(String s) {

    }
}
