package cn.winxo.mvp.module.example;

import android.content.Context;
import cn.winxo.mvp.api.entity.ResultsModel;
import cn.winxo.mvp.model.entity.Example;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;

/**
 * User: winxo
 * Date: 2016/10/19
 */
public class GankModel implements GankContact.Model {

  @Override public Observable<ArrayList<Example>> loadExampleList(Context context) {
    return Observable.just(new ArrayList<Example>())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }

  @Override public Observable<Example> loadExampleSingle(Context context) {
    return Observable.just(new Example())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }

  @Override public Observable<List<ResultsModel>> getGankData(int page) {
    //return RetrofitRequest.getInstance()
    //    .getGank()
    //    .getMeiziData(page)
    //    .(BaseModel::getResults)
    //    .subscribeOn(Schedulers.io())
    //    .observeOn(AndroidSchedulers.mainThread());
    return new Observable<List<ResultsModel>>() {
      @Override protected void subscribeActual(Observer<? super List<ResultsModel>> observer) {

      }
    };
  }
}
