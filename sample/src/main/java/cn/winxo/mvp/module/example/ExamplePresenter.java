package cn.winxo.mvp.module.example;

import android.content.Context;

import java.util.List;

import cn.winxo.mvp.mvp.base.BasePresenter;
import cn.winxo.mvp.model.entity.Example;

/**
 * @author dell
 * @date 2016/8/10 16:17
 */
public class ExamplePresenter extends BasePresenter<ExampleContract.View, ExampleContract.Model> implements ExampleContract.Presenter, IListener<List<Example>> {


    private final Context context;

    public ExamplePresenter(Context context) {
        this.context = context;
        mModel = new ExampleModel();
    }


    @Override
    public void getExample() {
        mModel.loadExampleList(context, this);
    }


    @Override
    public void onSuccess(List<Example> data) {
        getView().showExample(data);
    }

    @Override
    public void onError(String s) {
        getView().showError("error");
    }


    @Override
    public void start() {

    }
}
