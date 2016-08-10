package cn.winxo.mvp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import cn.winxo.mvp.R;
import cn.winxo.mvp.contract.ExampleContract;
import cn.winxo.mvp.model.entity.Example;
import cn.winxo.mvp.presenter.ExamplePresenter;

public class MainActivity extends AppCompatActivity implements ExampleContract.View {

    private ExamplePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new ExamplePresenter(this, this);

    }


    private void refresh() {
        presenter.getExample();
    }



    @Override
    public void setPresenter(ExampleContract.Presenter presenter) {

    }

    @Override
    public void showExample(List<Example> exampleList) {

    }

    @Override
    public void showError(String s) {

    }
}
