package cn.winxo.mvp.module.example;

import android.content.Context;

import java.util.List;

import cn.winxo.mvp.api.entity.ResultsModel;
import cn.winxo.mvp.mvp.base.BasePresenter;
import rx.Subscriber;

/**
 * @author dell
 * @date 2016/8/10 16:17
 */
public class GankPresenter extends BasePresenter<GankContact.View, GankContact.Model> implements GankContact.Presenter {


    private final Context context;

    public GankPresenter(Context context) {
        this.context = context;
        mModel = new GankModel();
    }


    @Override
    public void getExample() {
        mModel.getGankData(10)
                .subscribe(new Subscriber<List<ResultsModel>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<ResultsModel> resultsModels) {
                        mView.showExample(resultsModels);
                    }
                });
    }
}
