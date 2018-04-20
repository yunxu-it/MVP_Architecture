package cn.winxo.mvp.module.example;

import android.content.Context;
import cn.winxo.mvp.base.BasePresenter;
import cn.winxo.mvp.model.remote.ResultsModel;
import io.reactivex.functions.Consumer;
import java.util.List;

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
    mModel.getGankData(10).subscribe(new Consumer<List<ResultsModel>>() {
      @Override public void accept(List<ResultsModel> resultsModels) throws Exception {
        mView.showExample(resultsModels);
      }
    }, new Consumer<Throwable>() {
      @Override public void accept(Throwable throwable) throws Exception {

      }
    });
  }
}
