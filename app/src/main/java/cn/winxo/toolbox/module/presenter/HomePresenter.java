package cn.winxo.toolbox.module.presenter;

import android.content.Context;
import cn.winxo.toolbox.base.BasePresenter;
import cn.winxo.toolbox.module.conract.HomeContract;

public class HomePresenter extends BasePresenter<HomeContract.View>
    implements HomeContract.Presenter {

  private Context mContext;

  public HomePresenter(Context context) {
    mContext = context;
  }
}
