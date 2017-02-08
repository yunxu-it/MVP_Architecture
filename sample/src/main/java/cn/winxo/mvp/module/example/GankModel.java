package cn.winxo.mvp.module.example;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import cn.winxo.mvp.api.entity.BaseModel;
import cn.winxo.mvp.api.entity.ResultsModel;
import cn.winxo.mvp.api.retrofit.WinxoRetrofit;
import cn.winxo.mvp.model.entity.Example;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * User: winxo
 * Date: 2016/10/19
 */
public class GankModel implements GankContact.Model {

    @Override
    public Observable<ArrayList<Example>> loadExampleList(Context context) {
        return Observable.just(new ArrayList<Example>()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Example> loadExampleSingle(Context context) {
        return Observable.just(new Example()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<ResultsModel>> getGankData(int page) {
        return WinxoRetrofit.getInstance().getGank().getMeiziData(page)
                .map(BaseModel::getResults)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
