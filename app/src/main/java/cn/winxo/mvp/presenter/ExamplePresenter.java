package cn.winxo.mvp.presenter;

import android.content.Context;

import java.util.List;

import cn.winxo.mvp.contract.ExampleContract;
import cn.winxo.mvp.model.entity.Example;
import cn.winxo.mvp.model.remote.ExampleRemoteDataImpl;
import cn.winxo.mvp.model.IExampleData;

/**
 * @author dell
 * @date 2016/8/10 16:17
 */
public class ExamplePresenter implements ExampleContract.Presenter, IExampleData.IExampleListCallback {


    private final Context context;
    private final ExampleContract.View view;
    private final ExampleRemoteDataImpl iExample;

    public ExamplePresenter(Context context, ExampleContract.View view) {

        this.context = context;
        this.view = view;
        iExample = new ExampleRemoteDataImpl();
    }

    @Override
    public void onSuccess(List<Example> examples) {
        view.showExample(examples);
    }

    @Override
    public void onError() {
        view.showError("1");
    }

    @Override
    public void getExample() {
        iExample.loadExampleList(context, this);
    }


}
