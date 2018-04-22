package cn.winxo.mvp.module.presenter;

import android.content.Context;
import cn.winxo.mvp.base.BasePresenter;
import cn.winxo.mvp.module.conract.MainContract;

/**
 * User: winxo
 * Date: 2018/2/8
 * Time: 18:13
 * Email: yunxu.it@outlook.com
 * Desc:
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