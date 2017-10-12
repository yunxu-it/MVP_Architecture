package cn.winxo.mvp.module.example;

import android.content.Context;

import cn.winxo.mvp.library.mvp.base.BasePresenter;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import java.util.List;

import cn.winxo.mvp.api.entity.ResultsModel;

/**
 * @author dell
 * @date 2016/8/10 16:17
 */
public class GankPresenter extends BasePresenter<GankContact.View, GankContact.Model>
    implements GankContact.Presenter {

  private final Context context;

  public GankPresenter(Context context) {
    this.context = context;
    mModel = new GankModel();
  }

  @Override public void getExample() {
    mModel.getGankData(10).subscribe(new Observer<List<ResultsModel>>() {
      @Override public void onSubscribe(@NonNull Disposable d) {

      }

      @Override public void onNext(@NonNull List<ResultsModel> resultsModels) {
        mView.showExample(resultsModels);
      }

      @Override public void onError(@NonNull Throwable e) {

      }

      @Override public void onComplete() {

      }
    });
  }
}
