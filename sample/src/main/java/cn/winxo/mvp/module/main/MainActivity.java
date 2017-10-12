package cn.winxo.mvp.module.main;

import cn.winxo.mvp.api.entity.ResultsModel;
import cn.winxo.mvp.library.mvp.base.BaseMvpActivity;
import cn.winxo.mvp.module.example.GankContact;
import java.util.List;

public class MainActivity extends BaseMvpActivity<GankContact.Presenter>
    implements GankContact.View {

  @Override protected GankContact.Presenter onLoadPresenter() {
    return null;
  }

  @Override protected int setLayoutResourceID() {
    return 0;
  }

  @Override protected void setUpView() {

  }

  @Override public void showLoading() {

  }

  @Override public void hideLoading() {

  }

  @Override public void showExample(List<ResultsModel> exampleList) {

  }
}
