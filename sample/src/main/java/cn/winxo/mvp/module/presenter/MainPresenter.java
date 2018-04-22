package cn.winxo.mvp.module.presenter;

import android.content.Context;
import cn.winxo.mvp.base.BasePresenter;
import cn.winxo.mvp.module.conract.MainContract;

/**
 * @author lxlong
 * @date 22/04/2018
 * @desc
 */
public class MainPresenter extends BasePresenter<MainContract.View>
    implements MainContract.Presenter {

  private Context mContext;

  public MainPresenter(Context context) {
    mContext = context;
  }

  @Override public void changeText(int visibility) {
    mView.changeButton(visibility + "");
  }
}