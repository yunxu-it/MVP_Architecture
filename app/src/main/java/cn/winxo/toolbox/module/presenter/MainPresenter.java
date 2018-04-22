package cn.winxo.toolbox.module.presenter;

import android.content.Context;
import cn.winxo.toolbox.base.BasePresenter;
import cn.winxo.toolbox.module.conract.MainContract;

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