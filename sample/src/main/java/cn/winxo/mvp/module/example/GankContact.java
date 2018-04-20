package cn.winxo.mvp.module.example;

import android.content.Context;
import cn.winxo.mvp.base.ibase.IModel;
import cn.winxo.mvp.base.ibase.IPresenter;
import cn.winxo.mvp.base.ibase.IView;
import cn.winxo.mvp.model.local.Example;
import cn.winxo.mvp.model.remote.ResultsModel;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dell
 * @date 2016/8/10 16:15
 */
public interface GankContact {

  interface View extends IView {
    void showExample(List<ResultsModel> exampleList);
  }

  interface Model extends IModel {

    Observable<ArrayList<Example>> loadExampleList(Context context);

    Observable<Example> loadExampleSingle(Context context);

    Observable<List<ResultsModel>> getGankData(int page);
  }

  interface Presenter extends IPresenter<View> {
    void getExample();
  }
}