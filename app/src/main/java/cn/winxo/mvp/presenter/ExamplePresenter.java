package cn.winxo.mvp.presenter;

import android.content.Context;

import java.util.List;

import cn.winxo.mvp.contract.ExampleContract;
import cn.winxo.mvp.model.IExampleData;
import cn.winxo.mvp.model.entity.Example;
import cn.winxo.mvp.model.remote.ExampleRemoteDataImpl;
import cn.winxo.mvp.mvp.MvpPresenter;

/**
 * @author dell
 * @date 2016/8/10 16:17
 */
public class ExamplePresenter extends MvpPresenter<ExampleRemoteDataImpl, ExampleContract.View> implements ExampleContract.Presenter, IExampleData.IExampleListCallback {


    private final Context context;

    public ExamplePresenter(Context context) {
        this.context = context;
    }

    @Override
    public void onSuccess(List<Example> examples) {
        getView().showExample(examples);
    }

    @Override
    public void onError() {
        getView().showError("1");
    }

    @Override
    public void getExample() {
        mModel.loadExampleList(context, this);
    }


}
