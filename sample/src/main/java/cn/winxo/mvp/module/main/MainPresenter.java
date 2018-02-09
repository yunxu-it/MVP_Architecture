package cn.winxo.mvp.module.main;

import android.content.Context;
import cn.winxo.library.base.BasePresenter;

/**
 * User: winxo
 * Date: 2018/2/8
 * Time: 18:13
 * Email: yunxu.it@outlook.com
 * Desc:
 */
public class MainPresenter extends BasePresenter<MainContract.View, MainContract.Model>
    implements MainContract.Presenter {

  private Context mContext;

  public MainPresenter(Context context) {
    mContext = context;
    mModel = new MainModel();
  }
}