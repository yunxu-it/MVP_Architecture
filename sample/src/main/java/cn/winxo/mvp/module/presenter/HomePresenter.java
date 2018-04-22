package cn.winxo.mvp.module.presenter;

import android.content.Context;
import cn.winxo.mvp.base.BasePresenter;
import cn.winxo.mvp.module.conract.HomeContract;

public class HomePresenter extends BasePresenter<HomeContract.View>
    implements HomeContract.Presenter {

  private Context mContext;

  public HomePresenter(Context context) {
    mContext = context;
  }
}
